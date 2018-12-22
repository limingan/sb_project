package com.wisdom.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.wisdom.model.UserInfo;

public interface CommonSevice{
	
	public int saveCityInfo(String cityJsonArray);
	
	public int batchSaveCityInfo(String cityJsonArray);
	
	public List<Map<String,Object>> getCityListByCityName(String cityName);
}
