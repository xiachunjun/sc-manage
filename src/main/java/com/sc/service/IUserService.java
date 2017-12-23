package com.sc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sc.model.request.UserModel;

public interface IUserService {

	/**
	 * 用户注册
	 * @param userModel
	 */
	void register(UserModel userModel);

	/**
	 * 用户登录
	 * @param userModel
	 * @param request
	 */
	void login(UserModel userModel, HttpServletRequest request);

	/**
	 * 查询用户列表
	 * @return
	 */
	Map<String, Object> queryUsertList();

	
}
