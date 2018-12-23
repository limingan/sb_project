package com.common.util.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.wisdom.mapper.UserInfoMapper;
import com.wisdom.model.UserInfo;
import com.wisdom.service.LoginService;

@Component
public class UserInfoGuava {
	private Logger logger = LoggerFactory.getLogger(UserInfoGuava.class);
	private UserInfo userInfo;
	@Autowired
	private UserInfoMapper mapper;
	@Cacheable(value="userInfoGuavaCache", key="#accountId")
	public UserInfo getUserInfoByAccountId(String accountId){
		logger.info("从缓存获取不到，改为查数据库");
		userInfo = mapper.getUserInfoById(accountId);
		logger.info("从缓存获取不到，查数据库成功"+userInfo);
		return userInfo;
	}
	@CachePut(value="userInfoGuavaCache", key="#user.accountId")
	public UserInfo putUserInfo(UserInfo user){
		logger.info("查数据库，放入缓存");
		mapper.updateUserInfo(user);
		return user;
	}
	@CacheEvict(value="userInfoGuavaCache", key="#accountId")
	public void remove(String accountId){
		userInfo=null;
		logger.info("从缓存删除");
	}
}
