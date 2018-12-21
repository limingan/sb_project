package com.wisdom.mapper;

import java.util.List;
import java.util.Map;

public interface CommonMapper {

	public List<Map<String, Object>> getCityListByCityName(String cityName);
	
	public List<Map<String,Object>> getSunCityListByCityName(String cityName);
	
	public int saveCityInfo(Map<String,Object> city);
	
	public void batchSaveCityInfo(List cityList);
}