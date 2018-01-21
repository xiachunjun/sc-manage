package com.sc.model.request;

public class UserModel {

	/**用户登录名*/
	private String userLoginName;

	/**登录密码*/
	private String userLoginPwd;

	/**所属部门*/
	private String refDept;
	
	/**所属职位*/
	private String refPosi;
	
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

	public String getRefDept() {
		return refDept;
	}

	public String getRefPosi() {
		return refPosi;
	}

	public void setRefDept(String refDept) {
		this.refDept = refDept;
	}

	public void setRefPosi(String refPosi) {
		this.refPosi = refPosi;
	}
	
	
}
