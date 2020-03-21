package com.lihl.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IRuleConfig {

	@Bean
	public IRule randomRule() {
		return new RandomRule();
	}

}


