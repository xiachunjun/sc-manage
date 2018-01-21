package com.sc.support;

import com.sc.domain.User;

public class AuthUser {

	private Integer id;

	private String userCode;

	private String userName;

	private String userLoginName;

	private String userMobile;

	private String accessToken;

	private String refDept;

	private String refPosi;

	public AuthUser() {

	}

	public AuthUser(User user) {
		this.id = user.getId();
		this.userCode = user.getUserCode();
		this.userName = user.getUserName();
		this.userLoginName = user.getUserLoginName();
		// this.userMobile = user.getUserMobile();
		this.refDept = user.getRefDept();
		this.refPosi = user.getRefPosi();
	}

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
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
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

}
