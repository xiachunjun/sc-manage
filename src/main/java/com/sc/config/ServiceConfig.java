package com.sc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sc.service")
public class ServiceConfig {
	static Logger logger = LoggerFactory.getLogger(ServiceConfig.class);

}
