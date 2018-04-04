package com.smartpay.thrift.factory;

import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TTransport;

public class TMultiplexedProtocolFactory  implements TProtocolFactory{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2111810311940505865L;
	private TProtocol  protocol;
	private String serviceName;
	public TMultiplexedProtocolFactory(TProtocol  protocol, String serviceName){
		this.protocol = protocol;
		this.serviceName = serviceName;
		
	}

	@Override
	public TProtocol getProtocol(TTransport trans) {
		return new TMultiplexedProtocol(this.protocol, this.serviceName);
	}
	

}
