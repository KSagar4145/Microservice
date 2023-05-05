package com.lced.user.service.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfigFile {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplet() {
		return new RestTemplate();
	}
}
