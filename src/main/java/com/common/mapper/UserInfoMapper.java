package com.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.common.service.model.UserInfo;

public interface UserInfoMapper {
	
	public Map getUserInfoByName(String name);
	
	public List<Map<String,Object>> getUserList();
	
	public int saveCityInfo(Map<String,Object> city);
	
	public void batchSaveCityInfo(List cityList);
}
