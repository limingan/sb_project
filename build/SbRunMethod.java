package com.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
public class SbRunMethod {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SbRunMethod.class, args);
	}
}
