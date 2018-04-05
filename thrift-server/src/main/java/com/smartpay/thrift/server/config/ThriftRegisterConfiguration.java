package com.smartpay.thrift.server.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.smartpay.constants.AppConstants;
import com.smartpay.etcd.EtcdAutoConfiguration;
import com.smartpay.etcd.register.EtcdRegister;
import com.smartpay.thrift.server.utils.InetAddressUtil;

import mousio.etcd4j.EtcdClient;

/**
 * Created by dragon on 16/6/3.
 */
@Configuration
@Import(EtcdAutoConfiguration.class)
@AutoConfigureAfter({ ThriftAutoConfiguration.class })
@EnableConfigurationProperties({ ThriftServerProperties.class })
public class ThriftRegisterConfiguration {

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnProperty(value = "thrift.server.port", matchIfMissing = false)
	public EtcdRegister etcdRegister(EtcdClient etcdClient, ThriftServerProperties thriftServerProperties) {
		EtcdRegister register = new EtcdRegister();
		List<String> services = thriftServerProperties.getServiceNames();
		List<String> paths = new LinkedList<String>();
		for (String each : services) {
			paths.add(AppConstants.PATH + each);
		}
		register.setPaths(paths);
		String ip = InetAddressUtil.getLocalHostLANAddress().getHostAddress();
		String address = ip + ":" + String.valueOf(thriftServerProperties.getPort());
		register.setKey(address);
		register.setValue(address);
		register.setClient(etcdClient);
		register.setStart(true);

		return register;
	}

}
