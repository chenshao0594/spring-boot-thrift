package com.smartpay.springboot.thrift.server.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "thrift.server")
public class ThriftServerProperties {
	
	private int port;

	private int minWorker = Runtime.getRuntime().availableProcessors();

	private int maxWorker = Runtime.getRuntime().availableProcessors();

	private String serverName;
	
	private int workerQueueCapacity = 1024;

	private List<String> serviceNames;

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

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public List<String> getServiceNames() {
		return serviceNames;
	}

	public void setServiceNames(List<String> serviceNames) {
		this.serviceNames = serviceNames;
	}
	
}
