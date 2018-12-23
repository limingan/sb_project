package com.wisdom.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.wisdom.service.CommonSevice;
import com.common.util.cache.CodeMapGuava;
import com.wisdom.mapper.CommonMapper;
import com.wisdom.mapper.UserInfoMapper;
import com.wisdom.model.CodeMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
//@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.REPEATABLE_READ)
public class CommonServiceImpl implements CommonSevice {

	private Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
	@Autowired
	private CommonMapper commonMapper;
	@Autowired
	private CodeMapGuava codeMapGuava;
	
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

	@Override
	public CodeMap getCodeMapById(String codeId) {
		try{
			if(StringUtils.isNotBlank(codeId)){
				CodeMap codeMap = codeMapGuava.getCodeMapById(codeId);
				return codeMap;
			}
		}catch(Exception e){
			logger.error(codeId+">>>>>getCodeMapById error:", e);
		}
		return null;
	}

}
