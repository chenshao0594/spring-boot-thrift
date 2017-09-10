package com.smartpay.springboot.thrift.server.config;


import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.smartpay.springboot.etcd.EtcdAutoConfiguration;
import com.smartpay.springboot.etcd.register.EtcdRegister;
import com.smartpay.springboot.thrift.server.exception.ThriftServerException;
import com.smartpay.springboot.thrift.server.utils.InetAddressUtil;

import mousio.etcd4j.EtcdClient;

/**
 * Created by dragon on 16/6/3.
 */
@Configuration
@Import(EtcdAutoConfiguration.class)
@AutoConfigureAfter({ThriftAutoConfiguration.class})
@EnableConfigurationProperties({ThriftServerProperties.class})
public class ThriftRegisterConfiguration {
	private final static String PATH="/dragon/service/";

	private final Pattern DEFAULT_PACKAGE_PATTERN = Pattern.compile("(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnProperty(value = "thrift.server.port", matchIfMissing = false)
	public EtcdRegister etcdRegister(EtcdClient etcdClient,
			ThriftServerProperties thriftServerProperties) {
		EtcdRegister register = new EtcdRegister();
		List<String> services = thriftServerProperties.getServicenames();
		List<String> paths = new LinkedList<String>();
		for(String each: services){
			/*int lastComma = each.lastIndexOf(".");
			String interfaceName = each.substring(0, lastComma);
			if (!DEFAULT_PACKAGE_PATTERN.matcher(interfaceName).matches()) {
				throw new ThriftServerException("interface name is not match to package pattern");
			}*/
			paths.add(PATH+ each);
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
