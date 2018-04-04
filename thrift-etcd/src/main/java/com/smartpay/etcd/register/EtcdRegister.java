package com.smartpay.etcd.register;

import java.util.List;

import mousio.etcd4j.EtcdClient;


public class EtcdRegister {

	private boolean isStart = false;
	
	private EtcdClient client;
	
	private String serverName;

	private String key;
	
	private String value;
	
	private List<String> paths;
	
	public boolean isStart() {
		return isStart;
	}
	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
	public EtcdClient getClient() {
		return client;
	}
	public void setClient(EtcdClient client) {
		this.client = client;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<String> getPaths() {
		return paths;
	}
	public void setPaths(List<String> paths) {
		this.paths = paths;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	@Override
	public String toString() {
		return "EtcdRegister [isStart=" + isStart + ", client=" + client + ", serverName=" + serverName + ", key=" + key
				+ ", value=" + value + ", paths=" + paths + "]";
	}
	
	
	
}
