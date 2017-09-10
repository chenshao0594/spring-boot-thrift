package com.smartpay.springboot.thrift.client;


import com.smartpay.springboot.thrift.client.config.ThriftClientProperties;
import com.smartpay.springboot.thrift.client.pool.TransportPoolFactory;
import com.smartpay.springboot.thrift.client.route.Node;

import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;
import org.apache.thrift.transport.TTransport;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dragon on 16/5/6.
 */
@Configuration
@EnableConfigurationProperties(ThriftClientProperties.class)
public class ThriftClientConfiguration {


  @Bean(destroyMethod = "close")
  @ConditionalOnMissingBean
  public GenericKeyedObjectPool<Node, TTransport> thriftClientsPool(ThriftClientProperties thriftClientProperties) {
    GenericKeyedObjectPoolConfig config = new GenericKeyedObjectPoolConfig();
    config.setJmxEnabled(false); //cause spring will autodetect itself
    config.setMaxTotalPerKey(thriftClientProperties.getPoolMaxTotalPerKey());
    config.setMaxIdlePerKey(thriftClientProperties.getPoolMaxIdlePerKey());
    config.setMinIdlePerKey(thriftClientProperties.getPoolMinIdlePerKey());
    config.setMaxWaitMillis(thriftClientProperties.getPoolMaxWait());
    config.setTestOnReturn(true);
    TransportPoolFactory tpf = new TransportPoolFactory();
    return new GenericKeyedObjectPool<>(tpf, config);
  }
}
