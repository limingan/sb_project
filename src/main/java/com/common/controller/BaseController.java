package com.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.util.ResultFlagConstants;

public class BaseController {
	
	/**
	 * 成功统一返回封装，codeAndMsg：String code, String msg
	 * @param data
	 * @param codeAndMsg
	 * @return
	 */
	public String responseSuccess(Object data, String... codeAndMsg){
		Map<String,Object> resMap = new HashMap<String,Object>();
		String code,msg;
		if(codeAndMsg.length > 0){
			 code = codeAndMsg[0];
			 msg = codeAndMsg[1];
		}else{
			msg = ResultFlagConstants.RESULT_SUCCESS.getMsg();
			code = ResultFlagConstants.RESULT_SUCCESS.getCode();
		}
		resMap.put("msg", msg);
		resMap.put("code", code);
		resMap.put("data", data);
		return JSONObject.toJSONString(resMap);
	}
	/**
	 * 失败统一返回封装，codeAndMsg：String code, String msg
	 * @param data
	 * @param codeAndMsg
	 * @return
	 */
	public String responseFail(String... codeAndMsg){
		Map<String,Object> resMap = new HashMap<String,Object>();
		String code,msg;
		if(codeAndMsg.length > 0){
			 code = codeAndMsg[0];
			 msg = codeAndMsg[1];
		}else{
			msg = ResultFlagConstants.RESULT_SUCCESS.getMsg();
			code = ResultFlagConstants.RESULT_SUCCESS.getCode();
		}
		resMap.put("msg", msg);
		resMap.put("code", code);
		resMap.put("data", "");
		return JSONObject.toJSONString(resMap);
	}
}
