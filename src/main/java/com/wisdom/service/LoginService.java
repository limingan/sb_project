package com.wisdom.service;

import java.util.Map;

public interface LoginService {
	
	public Map<String,Object> login(String userName, String password);
	
	public Map<String,Object> getUserInfo(String accountId);
}
