package com.sc.model.request;

public class UserModel {
	private Integer id;

	/**
	 * 登录名
	 */
	private String userLoginName;

	/**
	 * 密码
	 */
	private String userLoginPwd;

	/**
	 * 身份证号
	 */
	private String userIdCard;

	/**
	 * 姓名
	 */
	private String userName;

	/**
	 * 昵称
	 */
	private String userNickname;

	/**所属岗位id*/
	private Integer refPosiId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public Integer getRefPosiId() {
		return refPosiId;
	}

	public void setRefPosiId(Integer refPosiId) {
		this.refPosiId = refPosiId;
	}
	
	
}
