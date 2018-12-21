package com.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.util.ResultFlagConstants;

public class BaseController {
	
	public String responseSuccess(Object data){
		Map<String,Object> resMap = new HashMap<String,Object>();
		resMap.put("msg", ResultFlagConstants.RESULT_SUCCESS.getMsg());
		resMap.put("code", ResultFlagConstants.RESULT_SUCCESS.getCode());
		resMap.put("data", data);
		return JSONObject.toJSONString(resMap);
	}
	
	public String responseFail(Map<String,String> msgMap){
		Map<String,Object> resMap = new HashMap<String,Object>();
		String msg = ResultFlagConstants.RESULT_ERROR.getMsg();
		String code = ResultFlagConstants.RESULT_ERROR.getCode();
		if(StringUtils.isNotBlank(msgMap.get("msg"))){
			msg = msgMap.get("msg");
		}
		if(StringUtils.isNotBlank(msgMap.get("code"))){
			code = msgMap.get("code");
		}
		resMap.put("msg", msg);
		resMap.put("code", code);
		resMap.put("data", "");
		return JSON.toJSONString(resMap);
	}
}
