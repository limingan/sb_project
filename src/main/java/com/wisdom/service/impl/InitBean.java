package com.wisdom.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class InitBean implements InitializingBean, ApplicationContextAware {
	
	private String myname;
	private ApplicationContext context;
	@Override
	public void afterPropertiesSet() throws Exception {
		InitBean initBean = context.getBean(InitBean.class);
		initBean.setMyname("chenpeng");
		System.out.println(initBean.getMyname());
	}

	@Override
	public void setApplicationContext(ApplicationContext paramApplicationContext) throws BeansException {
		System.out.println("chenpeng121121");
		this.context = paramApplicationContext;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

}
