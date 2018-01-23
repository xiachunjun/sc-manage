package com.sc.service;

import java.util.List;

import com.sc.domain.UserDomain;
import com.sc.model.request.UpdateUserPwdModel;
import com.sc.model.request.UserModel;

public interface IUserService {

	/**
	 * 用户注册
	 * 
	 * @param userModel
	 */
	void saveUser(UserModel userModel);

	/**
	 * 用户登录
	 * 
	 * @param userModel
	 * @param request
	 */
	UserDomain login(UserModel userModel);

	/**
	 * 查询用户列表
	 * 
	 * @return
	 */
	List<UserDomain> queryUsertList();

	/**
	 * 获取部门下的全部用户
	 * 
	 * @return
	 */
	List<UserDomain> queryByDept(String deptCode);

	/**
	 * 修改密码
	 */
	void updatePwd(UpdateUserPwdModel updateUserPwdModel);

}
