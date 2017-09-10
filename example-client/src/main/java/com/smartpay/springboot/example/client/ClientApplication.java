package com.smartpay.springboot.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dragon on 16/6/18.
 */
@SpringBootApplication
public class ClientApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication app = new SpringApplication(ClientApplication.class);
    app.setWebEnvironment(false);
    app.run(args);
  }
}
