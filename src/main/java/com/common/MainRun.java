package com.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
@SpringBootApplication(scanBasePackages="com")
@MapperScan("com.*.mapper")
@ServletComponentScan(basePackages={"com.common.filter","com.wisdom.db"})
public class MainRun {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(MainRun.class, args);
	}
}
