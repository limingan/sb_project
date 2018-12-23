package com.wisdom.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.controller.BaseController;
import com.wisdom.service.impl.CommonServiceImpl;

@RestController
public class CommonController extends BaseController {
	
	@Autowired
	private CommonServiceImpl commonService;
	
	@RequestMapping("/api/{method}")
	public String serviceByMethodId(@PathVariable String method,HttpServletRequest request){
		String url = request.getRequestURI();
		return "hello api routes :" + url;
	}
	
	@RequestMapping("/api/batchSaveCityInfo.do")
    public String batchSaveCityInfo(String cityInfo) {
		commonService.batchSaveCityInfo(cityInfo);
        return  super.responseSuccess("");
    }
	
	@RequestMapping("/common/city/getCityListByCityName.do")
    public String getCityListByCityName(String cityName) {
		List<Map<String,Object>> result = commonService.getCityListByCityName(cityName);
        return  super.responseSuccess(result);
    }
}
