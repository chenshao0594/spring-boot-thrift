package com.smartpay.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by dragon on 16/6/18.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class ClientApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(ClientApplication.class);
		app.setWebEnvironment(true);
		app.run(args);
	}
}
