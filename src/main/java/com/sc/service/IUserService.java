package com.sc.service;

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

	
}
