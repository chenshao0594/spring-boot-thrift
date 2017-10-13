package com.smartpay.springboot.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication app = new SpringApplication(ServerApplication.class);
    app.run(args);
  }
}
