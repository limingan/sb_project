package com.wisdom.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wisdom.service.impl.CommonServiceImpl;

@RestController
public class CommonController {
	
	@Autowired
	private CommonServiceImpl commonService;
	
	@RequestMapping("/api/{method}")
	public String serviceByMethodId(@PathVariable String method,HttpServletRequest request){
		String url = request.getRequestURI();
		return "hello api routes :" + url;
	}
	
	@RequestMapping("/api/getUserInfo.do")
    public String getUserInfo(@RequestParam String name) {
		Map userinfo = commonService.getUserInfoByName(name);
        return (String) userinfo.get("name");
    }
	
	@RequestMapping("/api/getUserList.do")
    public List getUserList() {
		List userinfos = commonService.getUserList();
        return  userinfos;
    }
	
	@RequestMapping("/api/insertCityInfo.do")
    public String getUserList(String cityInfo) {
		commonService.saveCityInfo(cityInfo);
        return  cityInfo;
    }
	
	@RequestMapping("/api/batchSaveCityInfo.do")
    public String batchSaveCityInfo(String cityInfo) {
		commonService.batchSaveCityInfo(cityInfo);
        return  cityInfo;
    }
}
