package com.common.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CommonInterceptorProcessor extends WebMvcConfigurerAdapter {
	
	@Value("${login.excludes}")
	private String excludes;
	@Autowired
	private CommonInterceptor commonInterceptor;
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration registrationCommon = registry.addInterceptor(commonInterceptor);
		InterceptorRegistration registrationLogin = registry.addInterceptor(loginInterceptor);
		registrationCommon.addPathPatterns("/**");
		registrationLogin.addPathPatterns("/**");
		registrationLogin.excludePathPatterns(getExcludes());
	}
	
	private String[] getExcludes(){
		String[] exArray = new String[]{};
		if(StringUtils.isNotBlank(this.excludes)){
			exArray = excludes.split(",");
		}
		return exArray;
	}
	
}
