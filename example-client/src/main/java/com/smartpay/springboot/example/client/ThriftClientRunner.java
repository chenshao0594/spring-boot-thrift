package com.smartpay.springboot.example.client;

import org.apache.thrift.async.AsyncMethodCallback;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dragon.study.springboot.example.api.Calculator;
import com.dragon.study.springboot.example.api.SharedService;
import com.smartpay.springboot.thrift.client.annotation.ThriftClient;

/**
 * Created by dragon on 16/7/7.
 */
@Component
public class ThriftClientRunner implements CommandLineRunner {

	@ThriftClient
	Calculator.Client client;

	@ThriftClient
	SharedService.Client sharedClient;
	
	@Override
	public void run(String... args) throws Exception {
		sharedClient.getStruct(89);
		//client.add(10, 20, new CallbackHandler());		
		System.out.println(client.add(20, 36));
	}
	
	class CallbackHandler<Integer>  implements AsyncMethodCallback<Integer> {
		@Override
		public void onComplete(Integer response) {
			System.out.println("async response" + response );
		}

		@Override
		public void onError(Exception exception) {
			System.out.println(exception);
			
		}

		
	}
}
