package com.wisdom.service.impl;

import java.lang.annotation.Annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
@Component
public class MyBeanPostProcessors implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		if(bean instanceof InitBean){
			System.out.println("执行了后置处理器的before方法"+bean+","+beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String paramString) throws BeansException {
		if(bean instanceof CommonServiceImpl){
			System.out.println("执行了后置处理器的After方法"+bean);
			Annotation[] arr = bean.getClass().getAnnotations();
			for(Annotation a : arr){
				System.out.println(a.annotationType());
			}
//			InitBean b = (InitBean) bean;
//			System.out.println("执行了后置处理器的before方法"+b.getMyname());
		}
		return bean;
	}

}
