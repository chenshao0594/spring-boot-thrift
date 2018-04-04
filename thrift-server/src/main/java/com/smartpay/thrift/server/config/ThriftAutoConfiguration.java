package com.smartpay.thrift.server.config;


import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;

import com.smartpay.thrift.monitor.TServerMonitorHandler;
import com.smartpay.thrift.server.annotation.ThriftService;
import com.smartpay.thrift.server.exception.ThriftServerException;

@Configuration
@EnableConfigurationProperties({ThriftServerProperties.class})
public class ThriftAutoConfiguration implements ApplicationContextAware {

	@Autowired
	private ThriftServerProperties thriftServerProperties;

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	private TProtocolFactory thriftProtocolFactory() {
		return new TBinaryProtocol.Factory(true, true);
	}

	private TNonblockingServerTransport thriftServerTransport() {
		TNonblockingServerTransport nonblockingServerTransport = null;
		try {
			int port = thriftServerProperties.getPort();
			if (port <= 0 || port >= 65535) {
				return null;
			}
			nonblockingServerTransport = new TNonblockingServerSocket(port);
		} catch (TTransportException e) {
			e.printStackTrace();
		}
		return nonblockingServerTransport;
	}

	private TProcessor thriftProcessor()
			throws Exception {
		TMultiplexedProcessor mprocessor = new TMultiplexedProcessor();
		String[] beanNames = applicationContext.getBeanNamesForAnnotation(ThriftService.class);
		List<String>  services = new LinkedList<String>();
		if(beanNames==null || beanNames.length==0 ){
			return mprocessor;
		}
		TProcessor processor = null;
		for(String thriftBeanName : beanNames){
			Object thriftServiceObj = this.applicationContext.getBean(thriftBeanName);
			Class<?>[] interfaces = ClassUtils.getAllInterfaces(thriftServiceObj);
			for(Class<?> clazz : interfaces){
				String serviceName = clazz.getEnclosingClass().getName();
				String processorName = serviceName +"$Processor";
				try{
					ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
					Class<?> processorClass=classLoader.loadClass(processorName);
					if(!TProcessor.class.isAssignableFrom(processorClass)){
						continue;						
					}
					Constructor<?> constructor = processorClass.getConstructor(clazz);
					processor = (TProcessor)constructor.newInstance(thriftServiceObj);
					mprocessor.registerProcessor(clazz.getEnclosingClass().getName(), processor);
					services.add(clazz.getEnclosingClass().getName());
					break;					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if (processor == null) {
				throw new Exception("service-class should implements Iface");
			}
		}
		this.thriftServerProperties.setServiceNames(services);
		return mprocessor;
	}


	private THsHaServer.Args thriftHsHaServerArgs() {
		THsHaServer.Args args;

		TNonblockingServerTransport transport = thriftServerTransport();
		if (transport == null) {
			return null;
		}
		args = new THsHaServer.Args(transport);
		TProtocolFactory protocolFactory = thriftProtocolFactory();
		args.protocolFactory(protocolFactory);
		TProcessor processor = null;
		try {
			processor = thriftProcessor();
		} catch (Exception e) {
		}

		if (processor == null) {
			return null;
		}
		args.processor(processor);

		args.executorService(createInvokerPool(thriftServerProperties.getMinWorker(),
				thriftServerProperties.getMaxWorker(), thriftServerProperties.getWorkerQueueCapacity()));

		ThreadPoolExecutor executor = (ThreadPoolExecutor) args.getExecutorService();
		executor.getQueue();
		return args;
	}

	private ExecutorService createInvokerPool(int minWorkerThreads, int maxWorkerThreads,
			int workerQueueCapacity) {
		int stopTimeoutVal = 60;
		TimeUnit stopTimeoutUnit = TimeUnit.SECONDS;

		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(workerQueueCapacity);
		ExecutorService invoker = new ThreadPoolExecutor(minWorkerThreads, maxWorkerThreads,
				stopTimeoutVal, stopTimeoutUnit, queue);

		return invoker;
	}


	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnProperty(value = "thrift.server.port", matchIfMissing = false)
	public TServer thriftServer() {
		String[] beanNames = applicationContext.getBeanNamesForAnnotation(ThriftService.class);
		if (beanNames == null || beanNames.length == 0) {
			throw new ThriftServerException("no thrift service");
		}

		THsHaServer.Args args = thriftHsHaServerArgs();
		if (args == null) {
			throw new ThriftServerException("args is null");
		}

		TServer server = new THsHaServer(args);
		server.setServerEventHandler(new TServerMonitorHandler());
		return server;
	}

}