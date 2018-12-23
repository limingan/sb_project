package com.wisdom.service;

import java.util.Map;

import com.wisdom.model.UserInfo;

public interface LoginService {
	
	public Map<String,Object> login(String userName, String password);
	
	public UserInfo getUserInfoById(String accountId);
}
