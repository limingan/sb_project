package com.common.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CommonInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView modelAndView)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//入参记录日志
		logParam(request);
		return true;
	}
	private void logParam(HttpServletRequest request) {
		try{
			Enumeration<String>  paramNames = request.getParameterNames();
			if(paramNames != null){
				Map<String,String> param = new HashMap<String,String>();
				while(paramNames.hasMoreElements()){
					String name = paramNames.nextElement();
					String value = request.getParameter(name);
					param.put(name, value);
				}
				logger.info("reqeust param>>>ip:"+getRealIp(request)+"," + request.getRequestURI() + ",accountId:" 
				+ request.getParameter("accountId") +">>>"+ param.toString());
			}
		}catch(Exception e){
			logger.error("param save error:", e);
		}
	}
	/**
     * 获取目标主机的ip
     * @param request
     * @return
     */
    private String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

}
