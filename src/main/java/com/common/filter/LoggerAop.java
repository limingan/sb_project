package com.common.filter;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAop {
	
	private Logger logger = LoggerFactory.getLogger(LoggerAop.class);
	
	@Pointcut( "@annotation(org.springframework.web.bind.annotation.RequestMapping)" )
	public void executeService(){
	}
	
	@Before("executeService()")
	public void before(JoinPoint joinPoint){
		
	}
	@AfterReturning(pointcut="executeService()", returning="ret")
	public void after(JoinPoint joinPoint, Object ret){
		Object[] args = joinPoint.getArgs();
		String url = "";
		String accountId = "";
		for(int i=0; i <args.length; i++){
			Object obj = args[i];
			if(obj instanceof HttpServletRequest){
				url = ((HttpServletRequest) obj).getRequestURI();
				accountId = ((HttpServletRequest) obj).getParameter("accountId");
				break;
			}
		}
		logger.info("response is>>>"+url+",accountId:" +accountId+">>>>>"+ret);
	}

}
