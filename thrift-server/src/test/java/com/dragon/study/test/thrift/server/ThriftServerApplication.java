package com.dragon.study.test.thrift.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dragon on 16/7/7.
 */
@SpringBootApplication
public class ThriftServerApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication app = new SpringApplication(ThriftServerApplication.class);
    app.run(args);
  }
}
