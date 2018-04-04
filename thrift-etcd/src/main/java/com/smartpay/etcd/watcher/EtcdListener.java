package com.smartpay.etcd.watcher;

import java.util.concurrent.CancellationException;

import mousio.client.promises.ResponsePromise;
import mousio.etcd4j.EtcdClient;
import mousio.etcd4j.responses.EtcdKeysResponse;

/**
 * Created by dragon on 16/5/3.
 */
public abstract class EtcdListener implements ResponsePromise.IsSimplePromiseResponseHandler<EtcdKeysResponse> {
	public EtcdListener(){}

	public EtcdListener(EtcdClient etcdClient, String listenPath) {
		this.etcdClient = etcdClient;
		this.listenPath = listenPath;
	}

	private EtcdClient etcdClient;
	private String watchPath = new String();
	protected String listenPath = new String();

	public String getWatchPath() {
		return watchPath;
	}

	public void setWatchPath(String watchPath) {
		this.watchPath = watchPath;
	}

	public String getListenPath() {
		return listenPath;
	}

	@Override
	public void onResponse(ResponsePromise<EtcdKeysResponse> responsePromise) {
		boolean hasClosed = false;
		try {
			EtcdKeysResponse response = responsePromise.get();
			if (response != null) {
				switch (response.action) {
				case expire:
				case delete:
				case set:
				case update:
				case create:
				case compareAndDelete:
				case compareAndSwap:
					changeEvent();
				default:
					break;
				}
			}
		} catch (Exception e) {
			if(e.getCause() instanceof CancellationException) {
				hasClosed = true;
				return ;
			} else {
			}
		} finally {
			while (true) {
				if(hasClosed) {
					break;
				}
				try {
					EtcdKeysResponse keysResponse = etcdClient.get(listenPath).send().get();
					if (keysResponse != null) {
						long modifyIndex = keysResponse.etcdIndex;
						etcdClient.get(listenPath).recursive().waitForChange(modifyIndex + 1).send()
						.addListener(this);
					} else {
					}
					break;
				} catch (Exception e) {
				}
			}
		}
	}

	protected abstract void changeEvent();

}
