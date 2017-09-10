package com.dragon.study.springboot.thrift.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Reilost on 15/11/27.
 */
@ConfigurationProperties(prefix = "thrift.client")
public class ThriftClientProperties {
	private int poolMaxTotalPerKey = 200;
	private int poolMaxIdlePerKey = 40;
	private int poolMinIdlePerKey = 10;
	private long poolMaxWait = 1000;
	public int getPoolMaxTotalPerKey() {
		return poolMaxTotalPerKey;
	}
	public void setPoolMaxTotalPerKey(int poolMaxTotalPerKey) {
		this.poolMaxTotalPerKey = poolMaxTotalPerKey;
	}
	public int getPoolMaxIdlePerKey() {
		return poolMaxIdlePerKey;
	}
	public void setPoolMaxIdlePerKey(int poolMaxIdlePerKey) {
		this.poolMaxIdlePerKey = poolMaxIdlePerKey;
	}
	public int getPoolMinIdlePerKey() {
		return poolMinIdlePerKey;
	}
	public void setPoolMinIdlePerKey(int poolMinIdlePerKey) {
		this.poolMinIdlePerKey = poolMinIdlePerKey;
	}
	public long getPoolMaxWait() {
		return poolMaxWait;
	}
	public void setPoolMaxWait(long poolMaxWait) {
		this.poolMaxWait = poolMaxWait;
	}


}
