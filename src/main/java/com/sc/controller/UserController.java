package com.sc.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.domain.User;
import com.sc.model.request.UserModel;
import com.sc.service.IUserService;
import com.sc.support.AuthUser;
import com.sc.support.TokenService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	@Autowired
	private TokenService tokenService;

	
	@RequestMapping("/outer/register")
	public String registerPage(Map<String, Object> map) {
		return "/addUser";
	}
	
	@RequestMapping("/outer/login")
	public String loginPage(Map<String, Object> map) {
		return "/login";
	}

	/**
	 * 注册用户
	 */
	@RequestMapping(value = "/outer/user/register", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse register(UserModel userModel) {
		DataResponse dr = null;
		try {
			userService.register(userModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("注册用户异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/outer/user/login", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse login(UserModel userModel, HttpServletRequest request, HttpServletResponse response) {
		DataResponse dr = null;
		try {
			User user = userService.login(userModel);
			if (null != user) {
				dr = produceToken(user, request, response);
			} else {
				dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
			}
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("用户登录异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 用户退出
	 */
	@RequestMapping(value = "/user/logout", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse logout(HttpServletRequest request) {
		request.getSession().removeAttribute(CommonConstant.USER_LOGIN_NAME);
		return new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
	}

	/**
	 * 查询用户列表
	 */
	@RequestMapping(value = "/user/query/list", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse queryUsertList() {
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = userService.queryUsertList();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询用户列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 查询当前用户
	 */
	@RequestMapping(value = "/user/currentUser", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse queryCurrentUser(HttpServletRequest request) {
		DataResponse dr = null;
		try {
			Object userNameObj = request.getSession().getAttribute(CommonConstant.USER_LOGIN_NAME);
			if (null != userNameObj) {
				dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
				dr.put(CommonConstant.USER_LOGIN_NAME, String.valueOf(userNameObj));
			} else {
				dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
			}
		} catch (Exception e) {
			logger.error("获取登录用户异常：", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
		}
		return dr;
	}
	
	
	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/user/pwd/update", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse updatePwd(@RequestParam(name="id", required=true)Integer id, 
			@RequestParam(name="password", required=true)String password) {
		DataResponse dr = null;
		try {
			userService.updatePwdById(id, password);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("修改密码异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/************************以下为私有方法****************************/

	private DataResponse produceToken(User user, HttpServletRequest request, HttpServletResponse response) {
		if (null == user) {
			return new DataResponse(ResponseEnum.RESPONSE_FAIL);
		}
		// 设置token并且添加到redis
		AuthUser authUser = tokenService.generateAccessTokenByUser(user);
		Cookie cookie = new Cookie(CommonConstant.ACCESS_TOKEN_KEY, authUser.getAccessToken());
		cookie.setPath(request.getContextPath() + "/");
		cookie.setMaxAge(3600);// 有效期10分钟
		response.addCookie(cookie);
		// 响应成功
		DataResponse dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		dr.put(CommonConstant.ACCESS_TOKEN_KEY, authUser.getAccessToken());
		return dr;
	}
	
}
