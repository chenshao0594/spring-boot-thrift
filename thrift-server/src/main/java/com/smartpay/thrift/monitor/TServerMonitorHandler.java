package com.smartpay.thrift.monitor;

import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.ServerContext;
import org.apache.thrift.server.TServerEventHandler;
import org.apache.thrift.transport.TTransport;

public class TServerMonitorHandler implements TServerEventHandler{

	@Override
	public void preServe() {
		// TODO Auto-generated method stub
		System.out.println("preServer ....");
		
	}

	@Override
	public ServerContext createContext(TProtocol input, TProtocol output) {
		System.out.println("createContext ....");
		return null;
	}

	@Override
	public void deleteContext(ServerContext serverContext, TProtocol input, TProtocol output) {
		System.out.println("delete Context ....");		
	}

	@Override
	public void processContext(ServerContext serverContext, TTransport inputTransport, TTransport outputTransport) {
		// TODO Auto-generated method stub
		
		System.out.println("process Context ....");
		
	}

}
