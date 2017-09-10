package com.dragon.study.springboot.thrift.client;


import com.dragon.study.springboot.thrift.client.route.RouterAlgorithm;

import java.lang.reflect.Constructor;

import lombok.Data;

public class ThriftClientBean {
	private RouterAlgorithm router;
	private int timeout;
	private int retryTimes;
	private Constructor<?> clientConstructor;
	public RouterAlgorithm getRouter() {
		return router;
	}
	public void setRouter(RouterAlgorithm router) {
		this.router = router;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public int getRetryTimes() {
		return retryTimes;
	}
	public void setRetryTimes(int retryTimes) {
		this.retryTimes = retryTimes;
	}
	public Constructor<?> getClientConstructor() {
		return clientConstructor;
	}
	public void setClientConstructor(Constructor<?> clientConstructor) {
		this.clientConstructor = clientConstructor;
	}

}
