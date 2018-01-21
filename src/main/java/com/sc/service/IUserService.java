package com.sc.service;

import java.util.List;
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
	List<User> queryUsertList();
	/**
	 * 获取部门下的全部用户
	 * @return
	 */
	List<User> queryByDept(String deptCode);

	/**
	 * 修改密码
	 * @param id
	 * @param password
	 */
	void updatePwdById(Integer id, String password);

	
}
