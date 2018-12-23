package com.wisdom.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.util.cache.UserInfoGuava;
import com.wisdom.mapper.UserInfoMapper;
import com.wisdom.model.UserInfo;
import com.wisdom.service.LoginService;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private UserInfoGuava userInfoGuava;
	
	@Override
	public Map<String, Object> login(String userName, String password) {
		Map<String,Object> loginResult = new HashMap<String,Object>();
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
			loginResult.put("errorMsg", "参数不能为空!");
			return loginResult;
		}
		UserInfo userInfo = userInfoMapper.getUserInfoByName(userName);
		if(userInfo == null){
			loginResult.put("errorMsg", "该用户未注册！");
			return loginResult;
		}else{
			if(password.equals(userInfo.getPassword())){
				loginResult.put("accountId", userInfo.getAccountId());
				loginResult.put("userName", userInfo.getUserName());
			}else{
				loginResult.put("errorMsg", "账号或密码错误！");
				return loginResult;
			}
		}
		return loginResult;
	}

	@Override
	public UserInfo getUserInfoById(String accountId) {
		UserInfo userInfo = userInfoGuava.getUserInfoByAccountId(accountId);
//		UserInfo userInfo = userInfoMapper.getUserInfoById(accountId);
		return userInfo;
	}

}
