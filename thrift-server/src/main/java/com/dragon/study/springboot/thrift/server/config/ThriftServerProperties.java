package com.dragon.study.springboot.thrift.server.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "thrift.server")
public class ThriftServerProperties {
	private int port;

	private int minWorker = Runtime.getRuntime().availableProcessors();

	private int maxWorker = Runtime.getRuntime().availableProcessors();

	private int workerQueueCapacity = 1024;

	private String serviceName;
	
	private List<String> servicenames;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getMinWorker() {
		return minWorker;
	}

	public void setMinWorker(int minWorker) {
		this.minWorker = minWorker;
	}

	public int getMaxWorker() {
		return maxWorker;
	}

	public void setMaxWorker(int maxWorker) {
		this.maxWorker = maxWorker;
	}

	public int getWorkerQueueCapacity() {
		return workerQueueCapacity;
	}

	public void setWorkerQueueCapacity(int workerQueueCapacity) {
		this.workerQueueCapacity = workerQueueCapacity;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<String> getServicenames() {
		return servicenames;
	}

	public void setServicenames(List<String> servicenames) {
		this.servicenames = servicenames;
	}
	
	

}
