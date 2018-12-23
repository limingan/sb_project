package com.wisdom.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.controller.BaseController;
import com.common.util.ResultFlagConstants;
import com.wisdom.model.UserInfo;
import com.wisdom.service.impl.LoginServiceImpl;

@RestController
public class LoginController extends BaseController {
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@RequestMapping("/wisdom/login.do")
    public String login(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
			return super.responseFail(ResultFlagConstants.RESULT_PARAM_IS_NULL.getCode(),ResultFlagConstants.RESULT_PARAM_IS_NULL.getMsg());
		}
		Map<String,Object> result = loginService.login(userName, password);
        return  super.responseSuccess(result);
    }
	
	@RequestMapping("/wisdom/getUserById.do")
    public String getUserById(HttpServletRequest request) {
		String accountId = request.getParameter("accountId");
		if(StringUtils.isBlank(accountId)){
			return super.responseFail(ResultFlagConstants.RESULT_PARAM_IS_NULL.getCode(),ResultFlagConstants.RESULT_PARAM_IS_NULL.getMsg());
		}
		UserInfo result = loginService.getUserInfoById(accountId);
        return  super.responseSuccess(result);
    }
	
	
}
