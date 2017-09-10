package com.smartpay.springboot.etcd;


import java.net.URI;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smartpay.springboot.etcd.config.EtcdClientProperties;

import mousio.client.retry.RetryNTimes;
import mousio.etcd4j.EtcdClient;

/**
 * Created by dragon on 16/6/3.
 */
@Configuration
@EnableConfigurationProperties(EtcdClientProperties.class)
public class EtcdAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public EtcdClient etcdClient(EtcdClientProperties etcdClientProperties) {
    List<URI> uriList = etcdClientProperties.getUris();
    if (uriList == null || uriList.isEmpty()) {
      return null;
    }

    EtcdClient client = new EtcdClient(uriList.toArray(new URI[uriList.size()]));
    client.setRetryHandler(new RetryNTimes(etcdClientProperties.getBeforeRetryTime(),
        etcdClientProperties.getRetryTimes()));

    if (client.version() == null) {
    	System.out.println("client version is null--------------------");
    }
    return client;
  }
}
