package com.snow.thrift.ext;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.snow.thrift.ext.ThreadTraceSpan;
import com.snow.thrift.ext.TraceSpanGenerator;
import com.snow.thrift.ext.protocol.TSnowProtocol;

public class ServiceAClient {

	public static void main(String[] args) {
		TTransport transport = null;
		try {
			transport = new TSocket("127.0.0.1", 8080);
			transport.open();
			TProtocol protocol = new TSnowProtocol(new TBinaryProtocol(transport), TraceSpanGenerator.instance());
			ServiceA.Client client = new ServiceA.Client(protocol);
			System.out.println(client.HelloWorld("test A"));
			System.out.println("CALL ServiceA traceID:=" + ThreadTraceSpan.get());
		} catch (TException e) {
			e.printStackTrace();
		} finally {
			transport.close();
		}
	}
}
