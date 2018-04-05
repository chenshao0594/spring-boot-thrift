package com.snow.thrift.ext;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import com.snow.thrift.ext.protocol.TSnowProtocol;

public class ServiceAServer {
	public static void main(String[] args) {
		try {
			TServerTransport strans = new TServerSocket(8080);
			ServiceA.Processor<ServiceA.Iface> processor = new ServiceA.Processor<>(new ServiceAImpl());
			TSimpleServer.Args serverArgs = new TSimpleServer.Args(strans);
			serverArgs.protocolFactory(new TSnowProtocol.Factory(new TBinaryProtocol.Factory()));
			serverArgs.processor(processor);
			TServer server = new TSimpleServer(serverArgs);
			server.serve();
		} catch (TException e) {
			e.printStackTrace();
		}

	}
}
