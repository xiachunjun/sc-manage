package com.sc.support;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.sc.common.constant.CommonConstant;

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);
	
	@Autowired
	TokenService tokenService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			System.out.println("path==="+request.getRequestURL());
			String accessToken = getAccessToken(request);
			logger.debug("AuthorizationInterceptor.preHandle==" + accessToken);
			AuthUser authUser = tokenService.getUserByAccessToken(accessToken);
			if (null != authUser) {
				UserContext.setAuthUser(authUser);
				logger.info("当前用户为："+JSONObject.toJSON(authUser));
				request.setAttribute(CommonConstant.USER_NAME, authUser.getUserName());
				return true;
			}
		} catch (Exception e) {
			logger.error("AuthorizationInterceptor.preHandle===", e);
		}
		response.sendRedirect("/outer/login");
		return false;
	}

	// =================以下是私有方法===================================
	private String getAccessToken(HttpServletRequest httpRequest) {
		String accessToken = null;
		accessToken = httpRequest.getHeader(CommonConstant.ACCESS_TOKEN_KEY);
		if (StringUtils.isBlank(accessToken)) {
			Cookie[] cookies = httpRequest.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie c = cookies[i];
					if (c.getName().equalsIgnoreCase(CommonConstant.ACCESS_TOKEN_KEY)) {
						accessToken = c.getValue();
						break;
					}
				}
			}
		}
		return accessToken;
	}
}
