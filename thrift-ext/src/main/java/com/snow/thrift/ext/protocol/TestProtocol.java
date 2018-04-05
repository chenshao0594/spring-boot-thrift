package com.snow.thrift.ext.protocol;

import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolDecorator;

public class TestProtocol extends TProtocolDecorator {

	public TestProtocol(TProtocol protocol) {
		super(protocol);
		// TODO Auto-generated constructor stub
	}

}
