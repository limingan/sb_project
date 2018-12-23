package com.common.util.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.wisdom.mapper.CommonMapper;
import com.wisdom.mapper.UserInfoMapper;
import com.wisdom.model.CodeMap;
import com.wisdom.model.UserInfo;
import com.wisdom.service.LoginService;

@Component
public class CodeMapGuava {
	private Logger logger = LoggerFactory.getLogger(CodeMapGuava.class);
	private CodeMap codeMap;
	@Autowired
	private CommonMapper mapper;
	@Cacheable(value="userInfoGuavaCache", key="'codemap'+#codeId")
	public CodeMap getCodeMapById(String codeId){
		logger.info("从缓存获取不到，改为查数据库");
		codeMap = mapper.getCodeMapById(codeId);
		logger.info("从缓存获取不到，查数据库成功"+codeMap);
		return codeMap;
	}
//	@CachePut(value="userInfoGuavaCache", key="#user.accountId")
//	public UserInfo putUserInfo(UserInfo user){
//		logger.info("查数据库，放入缓存");
//		mapper.updateUserInfo(user);
//		return user;
//	}
//	@CacheEvict(value="userInfoGuavaCache", key="#codeId")
//	public void remove(String codeId){
//		codeMap=null;
//		logger.info("从缓存删除");
//	}
}
