package com.wisdom.mapper;

import java.util.List;
import java.util.Map;

import com.wisdom.model.UserInfo;

public interface UserInfoMapper {
	
	public Map getUserInfoByName(String name);
	
	public List<Map<String,Object>> getUserList();
	
}
