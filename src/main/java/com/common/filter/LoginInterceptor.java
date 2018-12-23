package com.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wisdom.model.CodeMap;
import com.wisdom.service.impl.CommonServiceImpl;
@Component
public class LoginInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	@Autowired
	private CommonServiceImpl commonService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("LoginInterceptor preHandler begin>>>>>>");
		String token = request.getParameter("token");
		String accountId = request.getParameter("accountId");
		CodeMap codeMap = commonService.getCodeMapById("checkTokenSwitch"); //从数据库查开关，根据开关是否校验token
		if(codeMap != null && "Y".equals(codeMap.getAttribute1())){
			if(StringUtils.isBlank(token) || StringUtils.isBlank(accountId)){
				return false;
			}
		}	
		logger.info("LoginInterceptor preHandler end>>>>>>");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
