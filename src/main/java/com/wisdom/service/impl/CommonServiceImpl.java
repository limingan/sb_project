package com.wisdom.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wisdom.service.CommonSevice;
import com.wisdom.mapper.CommonMapper;
import com.wisdom.mapper.UserInfoMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
//@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.REPEATABLE_READ)
public class CommonServiceImpl implements CommonSevice {

	@Autowired
	private JdbcTemplate template;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private CommonMapper commonMapper;
	
	@Override
	public Map getUserInfo(String name) {
		String sql = "select * from userinfo where name=?";
		Map<String,Object> userinfo = template.queryForMap(sql, name);
		return userinfo;
	}
	@Override
	public Map getUserInfoByName(String name) {
		Map userInfo = userInfoMapper.getUserInfoByName(name);
		return userInfo;
	}
	
	public List<Map<String,Object>> getUserList(){
		List<Map<String, Object>> list = userInfoMapper.getUserList();
		return list;
	}
	
	public int saveCityInfo(String cityJsonArray){
		JSONArray array = JSONArray.fromObject(cityJsonArray);
		Map<String,Object> param = new HashMap<String,Object>();
		for(int i = 0 ; i < array.size(); i ++){
			JSONObject obj = array.getJSONObject(i);
			String province = obj.getString("name");
			JSONArray cityArray = obj.getJSONArray("city");
			for(int j = 0 ; j < cityArray.size(); j ++){
				JSONObject city = cityArray.getJSONObject(j);
				String cityName = city.getString("name");
				JSONArray areaArray = city.getJSONArray("area");
				for(int k = 0; k < areaArray.size(); k ++){
					String area = areaArray.getString(k);
					param.put("province", province);
					param.put("city", cityName);
					param.put("area", area);
					commonMapper.saveCityInfo(param);
					param.clear();
				}
			}
		}
		return 1;
	}
	
	public int batchSaveCityInfo(String cityJsonArray){
		JSONArray array = JSONArray.fromObject(cityJsonArray);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i = 0 ; i < array.size(); i ++){
			JSONObject obj = array.getJSONObject(i);
			String province = obj.getString("name");
			JSONArray cityArray = obj.getJSONArray("city");
			for(int j = 0 ; j < cityArray.size(); j ++){
				JSONObject city = cityArray.getJSONObject(j);
				String cityName = city.getString("name");
				JSONArray areaArray = city.getJSONArray("area");
				for(int k = 0; k < areaArray.size(); k ++){
					String area = areaArray.getString(k);
					Map<String,Object> param = new HashMap<String,Object>();
					param.put("province", province);
					param.put("city", cityName);
					param.put("area", area);
					list.add(param);
				}
			}
		}
		commonMapper.batchSaveCityInfo(list);
		return list.size();
	}
	@Override
	public List<Map<String, Object>> getCityListByCityName(String cityName) {
		List<Map<String,Object>> result = commonMapper.getCityListByCityName(cityName);
		return result;
	}

}
