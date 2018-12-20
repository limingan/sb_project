package com.wisdom.db;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DuridDataSourceConfig {
	
	@Value("${spring.datasource.druid.filters}")
    private String filters ;
	@Value("${spring.datasource.druid.exceptionSorter}")
	private String exceptionSorter;
	
	@Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        try {
            dataSource.setFilters(filters);
            dataSource.setExceptionSorter(exceptionSorter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
