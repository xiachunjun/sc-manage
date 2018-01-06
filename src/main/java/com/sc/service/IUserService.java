package com.sc.service;

import java.util.Map;

import com.sc.domain.User;
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
	User login(UserModel userModel);

	/**
	 * 查询用户列表
	 * @return
	 */
	Map<String, Object> queryUsertList();

	
}
