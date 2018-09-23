package com.sc.model.request;

public class QueryUserModel {
	/* 用户登录名 */
	private String userLoginName;

	/* 登录密码 */
	private String userLoginPwd;

	private String userName;

	/* 所属部门 */
	private String refDeptCode;

	/* 所属职位 */
	private String refPosiCode;

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserLoginPwd() {
		return userLoginPwd;
	}

	public void setUserLoginPwd(String userLoginPwd) {
		this.userLoginPwd = userLoginPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRefDeptCode() {
		return refDeptCode;
	}

	public void setRefDeptCode(String refDeptCode) {
		this.refDeptCode = refDeptCode;
	}

	public String getRefPosiCode() {
		return refPosiCode;
	}

	public void setRefPosiCode(String refPosiCode) {
		this.refPosiCode = refPosiCode;
	}

}
