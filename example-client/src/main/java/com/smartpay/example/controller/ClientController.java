package com.smartpay.example.controller;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.study.springboot.example.api.Calculator;
import com.dragon.study.springboot.example.api.SharedService;
import com.smartpay.thrift.client.annotation.ThriftClient;

/**
 * Created by dragon on 16/7/7.
 */
@RestController()
@RequestMapping()
public class ClientController {

	@ThriftClient
	Calculator.Client client;

	@ThriftClient
	SharedService.Client sharedClient;

	@PostConstruct
	public void run() throws Exception {
		sharedClient.getStruct(89);
		System.out.println("Thrift Client Test Service result is " + client.add(20, 36));
	}

}
