package com.snow.thrift.ext;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import com.snow.thrift.ext.protocol.TSnowProtocol;


public class ServiceBServer {
public static void main(String[] args) {
	try {
		TServerTransport strans = new TServerSocket(8081);
		ServiceA.Processor<ServiceA.Iface> processor = new ServiceA.Processor<>(new ServiceBImpl());
		TSimpleServer.Args serverArgs =new TSimpleServer.Args(strans);
		serverArgs.protocolFactory(new TSnowProtocol.Factory(new TCompactProtocol.Factory()));
		serverArgs.processor(processor);
		TServer server = new TSimpleServer(serverArgs);
		server.serve();
	} catch (TException e) {
		e.printStackTrace();
	}
	
}
}
