package com.sc.model.request;

public class UserModel {

	/**用户登录名*/
	private String userLoginName;

	/**登录密码*/
	private String userLoginPwd;

	
	public String getUserLoginName() {
		return userLoginName;
	}

	public String getUserLoginPwd() {
		return userLoginPwd;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public void setUserLoginPwd(String userLoginPwd) {
		this.userLoginPwd = userLoginPwd;
	}
	
	
}
