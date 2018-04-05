package com.snow.thrift.ext;

import org.apache.thrift.TException;

import com.snow.thrift.ext.ThreadTraceSpan;

public class ServiceAImpl implements ServiceA.Iface {

	@Override
	public String HelloWorld(String name) throws TException {
		System.out.println("ServiceA traceID:=" + ThreadTraceSpan.get() + ",args：" + name);
		return "hello,world:" + name + " from service A  ...";
	}

}
