package com.sc.support;
//
//import java.io.PrintWriter;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.alibaba.fastjson.JSONObject;
//import com.wanda.merchant.loan.constant.CommonConstant;
//import com.wanda.merchant.loan.constant.ResponseEnum;
//
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
//
//	@Autowired
//	MerchantRedisCache merchantRedisCache;
//
//	@Autowired
//	TokenService tokenService;
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		try {
//			String accessToken = getAccessToken(request);
//			MerchantLogger.debug(this, "AuthorizationInterceptor.preHandle==", accessToken);
//			AuthUser authUser = tokenService.getUserByAccessToken(accessToken);
//			if (null != authUser) {
//				UserContext.setAuthUser(authUser);
//				MerchantLogger.info(this, "当前用户为：",authUser);
//				return true;
//			}
//		} catch (Exception e) {
//			MerchantLogger.error(this, "AuthorizationInterceptor.preHandle===", e);
//		}
//		DataResponse dataResponse = new DataResponse(ResponseEnum.RESPONSE_NOT_LOGIN);
//		String jsonStr = JSONObject.toJSONString(dataResponse);
//		MerchantLogger.info(this, "AuthorizationInterceptor.preHandle==用户未登录：" + jsonStr);
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println(jsonStr);
//		out.flush();
//		out.close();
//		return false;
//	}
//
//	// =================以下是私有方法===================================
//	private String getAccessToken(HttpServletRequest httpRequest) {
//		String accessToken = null;
//		accessToken = httpRequest.getHeader(CommonConstant.ACCESS_TOKEN_KEY);
//		if (StringUtils.isBlank(accessToken)) {
//			Cookie[] cookies = httpRequest.getCookies();
//			if (cookies != null) {
//				for (int i = 0; i < cookies.length; i++) {
//					Cookie c = cookies[i];
//					if (c.getName().equalsIgnoreCase(CommonConstant.ACCESS_TOKEN_KEY)) {
//						accessToken = c.getValue();
//						break;
//					}
//				}
//			}
//		}
//		return accessToken;
//	}
}
