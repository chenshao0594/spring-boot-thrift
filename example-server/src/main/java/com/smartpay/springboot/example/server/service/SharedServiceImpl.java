package com.smartpay.springboot.example.server.service;

import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

import com.dragon.study.springboot.example.api.SharedService;
import com.dragon.study.springboot.example.api.SharedStruct;
import com.smartpay.thrift.server.annotation.ThriftService;

@Component
@ThriftService
public class SharedServiceImpl implements SharedService.Iface {

	@Override
	public SharedStruct getStruct(int arg0) throws TException {
		System.out.println("sharedservice work !!! from example server  =======");
		return new SharedStruct();
	}

}
