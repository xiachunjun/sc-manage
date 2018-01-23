package com.sc.support;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.ScException;
import com.sc.domain.UserDomain;

@Component
public class TokenService {

	private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

	@Autowired
	RedisCache redisCache;

	/**
	 * 生成token
	 * 
	 * @param user
	 * @return
	 */
	public AuthUser generateAccessToken(AuthUser authUser) {
		if (null == authUser) {
			throw new ScException("TokenService.generateAccessToken===authUser为空！");
		}
		authUser.setAccessToken(UUID.randomUUID().toString());
		try {
			redisCache.setObjWithExpiry(CommonConstant.ACCESS_TOKEN_KEY + authUser.getAccessToken(), authUser, 600);
		} catch (Exception e) {
			logger.error("TokenService.generateAccessToken===", e);
			throw new ScException(e);
		}
		return authUser;
	}

	public AuthUser generateAccessTokenByUser(UserDomain userDomain) {
		if (null == userDomain) {
			throw new ScException("TokenService.generateAccessTokenByUser===userDomain为空！");
		}
		return this.generateAccessToken(new AuthUser(userDomain));
	}

	public AuthUser getUserByAccessToken(String accessToken) {
		AuthUser authUser = null;
		try {
			/** 如果accessToken还剩5分钟内就过期的话，给它重新设置失效时间为10分钟 */
			Long time = redisCache.getExpireByKey(CommonConstant.ACCESS_TOKEN_KEY + accessToken);
			if (time <= 300) {
				redisCache.expire(CommonConstant.ACCESS_TOKEN_KEY + accessToken, 600);
			}
			authUser = redisCache.getObject(CommonConstant.ACCESS_TOKEN_KEY + accessToken, AuthUser.class);
		} catch (Exception e) {
			logger.error("TokenService.getUserByAccessToken===", e);
		}
		return authUser;
	}

	/**
	 * 登出
	 * 
	 * @param authUser
	 * @return
	 */
	public AuthUser logout(AuthUser authUser) {
		try {
			redisCache.delete(CommonConstant.ACCESS_TOKEN_KEY + authUser.getAccessToken());
		} catch (Exception e) {
			logger.error("TokenService.logout===", e);
		}
		return authUser;
	}
}
