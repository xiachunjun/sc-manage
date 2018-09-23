package com.sc.support;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.ScException;
import com.sc.domain.UserDomain;

@Component
public class TokenService {

	private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

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
			StaticCacheMap.put(CommonConstant.ACCESS_TOKEN_KEY + authUser.getAccessToken(), authUser);
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
			authUser = (AuthUser) StaticCacheMap.get(CommonConstant.ACCESS_TOKEN_KEY + accessToken);
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
			StaticCacheMap.remove(CommonConstant.ACCESS_TOKEN_KEY + authUser.getAccessToken());
		} catch (Exception e) {
			logger.error("TokenService.logout===", e);
		}
		return authUser;
	}
}
