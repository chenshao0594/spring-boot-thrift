package com.dragon.study.springboot.etcd.register;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.dragon.study.springboot.etcd.EtcdAutoConfiguration;
import com.dragon.study.springboot.etcd.config.EtcdDiscoveryProperties;

import mousio.etcd4j.EtcdClient;

/**
 * Created by dragon on 16/6/3.
 */
@Configuration
@EnableScheduling
@ConditionalOnBean(name = "thriftServer")
@AutoConfigureAfter(name = "com.dragon.study.springboot.thrift.server.ThriftServerBootstrap")
@EnableConfigurationProperties(EtcdDiscoveryProperties.class)
@Import(EtcdAutoConfiguration.class)
public class EtcdRegisterConfiguration {

	@Autowired
	private EtcdRegister etcdRegister;

	@Autowired
	private EtcdClient etcdClient;

	@Autowired
	private EtcdDiscoveryProperties etcdRegisterProperties;

	private static final Pattern DEFAULT_ADDRESS_PATTERN = Pattern.compile("\\d{1,3}(?:\\.\\d{1,3}){3}(?::\\d{1,5})?");

	private boolean isRefresh = false;

	@Scheduled(initialDelayString = "${etcd.discovery.heartbeat:5000}", fixedRateString = "${spring.cloud.etcd.discovery.heartbeat:5000}")
	protected void sendHeartbeat() {
		register();
	}

	private void register() {
		if (!etcdRegister.isStart()) {
			return;
		}
		String registerKey = etcdRegister.getKey();
		String value = etcdRegister.getValue();
		for(String registerPath : etcdRegister.getPaths() ){
			if (registerPath != null && registerKey != null && value != null && DEFAULT_ADDRESS_PATTERN.matcher(registerKey).matches()) {
				String path = registerPath + "/" + registerKey;
				int sessionTime = etcdRegisterProperties.getTtl();
				try {
					if (isRefresh) {
						etcdClient.refresh(path, sessionTime).send().get();
					} else {
						etcdClient.put(path, value).ttl(sessionTime).send().get();
					}
				} catch (Exception e) {
					try {
						etcdClient.put(path, value).ttl(sessionTime).send().get();
					} catch (Exception ex) {
					}
				}
			}
		}
		this.isRefresh = true;
		
	}
}
