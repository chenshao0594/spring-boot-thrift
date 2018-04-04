package com.smartpay.thrift.client;


import java.lang.reflect.Constructor;

import com.smartpay.thrift.client.route.RouterAlgorithm;

public class ThriftClientBean {
	private RouterAlgorithm router;
	private int timeout;
	private int retryTimes;
	private Constructor<?> clientConstructor;
	private boolean isAsync=false;
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
	public boolean isAsync() {
		return isAsync;
	}
	public void setAsync(boolean isAsync) {
		this.isAsync = isAsync;
	}
	

}
