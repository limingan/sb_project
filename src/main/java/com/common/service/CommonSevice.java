package com.common.service;

import java.util.List;
import java.util.Map;

import com.common.service.model.UserInfo;

public interface CommonSevice {
	
	public Map getUserInfo(String name);
	
	public Map getUserInfoByName(String name);
	
	public List<Map<String,Object>> getUserList();
	
	public int saveCityInfo(String cityJsonArray);
	
	public int batchSaveCityInfo(String cityJsonArray);
}
