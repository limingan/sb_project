package com.wisdom.mapper;

import java.util.List;
import java.util.Map;

import com.wisdom.model.UserInfo;

public interface UserInfoMapper {
	
	public UserInfo getUserInfoByName(String name);
	
	public UserInfo getUserInfoById(String accountId);
	
	public List<Map<String,Object>> getUserList();
	
	public int updateUserInfo(UserInfo userInfo);
	
}
