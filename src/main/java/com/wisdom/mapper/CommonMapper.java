package com.wisdom.mapper;

import java.util.List;
import java.util.Map;

import com.wisdom.model.CodeMap;

public interface CommonMapper {

	public List<Map<String, Object>> getCityListByCityName(String cityName);
	
	public List<Map<String,Object>> getSunCityListByCityName(String cityName);
	
	public int saveCityInfo(Map<String,Object> city);
	
	public void batchSaveCityInfo(List cityList);
	//根据codeId获取配置项
	public CodeMap getCodeMapById(String codeId);
}