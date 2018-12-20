package com.wisdom.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.wisdom.model.UserInfo;

public interface CommonSevice extends InitializingBean{
	
	public Map getUserInfo(String name);
	
	public Map getUserInfoByName(String name);
	
	public List<Map<String,Object>> getUserList();
	
	public int saveCityInfo(String cityJsonArray);
	
	public int batchSaveCityInfo(String cityJsonArray);
}
