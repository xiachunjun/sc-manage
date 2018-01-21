package com.sc.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	private Integer id;

	/**
	 * 用户代码
	 */
	private String userCode;

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
	/**
	 * 所属部门
	 */
	private String refDept;
	/**
	 * 所属岗位
	 */
	private String refPosi;

	private Integer dataState;

	@JsonIgnore
	private Integer dataVersion;

	@JsonIgnore
	private String createUser;

	@JsonIgnore
	private String updateUser;

	@JsonIgnore
	private Date createTime;

	@JsonIgnore
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode == null ? null : userCode.trim();
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName == null ? null : userLoginName.trim();
	}

	public String getUserLoginPwd() {
		return userLoginPwd;
	}

	public void setUserLoginPwd(String userLoginPwd) {
		this.userLoginPwd = userLoginPwd == null ? null : userLoginPwd.trim();
	}

	public String getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard == null ? null : userIdCard.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname == null ? null : userNickname.trim();
	}

	public String getRefDept() {
		return refDept;
	}

	public void setRefDept(String refDept) {
		this.refDept = refDept;
	}

	public String getRefPosi() {
		return refPosi;
	}

	public void setRefPosi(String refPosi) {
		this.refPosi = refPosi;
	}

	public Integer getDataState() {
		return dataState;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	public Integer getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(Integer dataVersion) {
		this.dataVersion = dataVersion;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}