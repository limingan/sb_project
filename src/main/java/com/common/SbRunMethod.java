package com.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.common.mapper")
public class SbRunMethod {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SbRunMethod.class, args);
	}
}
