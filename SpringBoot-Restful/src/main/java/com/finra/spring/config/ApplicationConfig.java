package com.finra.spring.config;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.finra.spring")
@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationConfig extends SpringBootServletInitializer {
	private static final Logger logger = Logger.getLogger(ApplicationConfig.class);

	public static void main(String[] args) throws Exception {
		logger.info("Spring Boot Application starts!!!");
		SpringApplication.run(ApplicationConfig.class, args);
	}

}
