package com.dragon.study.springboot.thrift.client.route;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by dragon on 16/5/6.
 */
@Data
@EqualsAndHashCode(exclude = {"timeout"})
@ToString
public class Node {
	private String ip;
	private int port;
	private int timeout = 500;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	@Override
	public String toString() {
		return "Node [ip=" + ip + ", port=" + port + ", timeout=" + timeout + "]";
	}


}
