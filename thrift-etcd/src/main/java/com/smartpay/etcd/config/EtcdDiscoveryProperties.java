package com.smartpay.etcd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by dragon on 16/4/13.
 */
@ConfigurationProperties(prefix = "etcd.discovery")
public class EtcdDiscoveryProperties {
	int heartbeat = 5000;
	int ttl = 10;
	public int getHeartbeat() {
		return heartbeat;
	}
	public void setHeartbeat(int heartbeat) {
		this.heartbeat = heartbeat;
	}
	public int getTtl() {
		return ttl;
	}
	public void setTtl(int ttl) {
		this.ttl = ttl;
	}


}
