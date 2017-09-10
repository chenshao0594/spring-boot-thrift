package com.dragon.study.springboot.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dragon on 16/6/18.
 */
@SpringBootApplication
public class ServerApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication app = new SpringApplication(ServerApplication.class);
    app.run(args);
  }
}
