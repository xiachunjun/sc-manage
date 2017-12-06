//package com.sc.support;
//
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import com.wanda.merchant.loan.constant.CommonConstant;
//
//@Component
//public class TokenService {
//
//	@Value("${app.access-token-timeout}")
//	private Integer accessTimeout;
//
//	@Value("${app.refresh-token-timeout}")
//	private Integer refreshTimeout;
//
//	@Autowired
//	MerchantRedisCache merchantRedisCache;
//
//	/**
//	 * 生成token
//	 * 
//	 * @param user
//	 * @return
//	 */
//	public void generateAccessToken(final AuthUser authUser) {
//		if (null == authUser) {
//			throw new MerchantException("TokenService.generateAccessToken===user为空！");
//		}
//		authUser.setAccessToken(UUID.randomUUID().toString());
//		authUser.setRefreshToken(UUID.randomUUID().toString());
//		try {
//			//TODO 需要再次改进  管道中开始获取不到key对应的value？？？
//			merchantRedisCache.pipelinedLogin(authUser);
//		} catch (Exception e) {
//			MerchantLogger.error(this, "TokenService.generateAccessToken===", e);
//			throw new MerchantException(e);
//		}
//	}
//
//	public AuthUser getUserByAccessToken(String accessToken) {
//		AuthUser authUser = null;
//		try {
//			/**如果accessToken还剩5分钟内就过期的话，给它重新设置失效时间为10分钟*/
//			Long time = merchantRedisCache.getExpireByKey(CommonConstant.ACCESS_TOKEN_PREFIX+accessToken);
//			if(time <= 300){
//				merchantRedisCache.expire(CommonConstant.ACCESS_TOKEN_PREFIX+accessToken, accessTimeout);
//			}
//			authUser = merchantRedisCache.getObject(CommonConstant.ACCESS_TOKEN_PREFIX+accessToken, AuthUser.class);
//		} catch (Exception e) {
//			MerchantLogger.error(this, "TokenService.generateAccessToken===", e);
//			return null;
//		}
//		return authUser;
//	}
//
//	public AuthUser getUserByRefreshToken(String refreshToken) {
//		AuthUser authUser = null;
//		try {
//			authUser = merchantRedisCache.getObject(CommonConstant.REFRESH_TOKEN_PREFIX+refreshToken, AuthUser.class);
//		} catch (Exception e) {
//			MerchantLogger.error(this, "TokenService.generateAccessToken===", e);
//			return null;
//		}
//		return authUser;
//	}
//
//}
