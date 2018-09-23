package com.sc.support;

import com.sc.domain.UserDomain;

public class AuthUser {

	private Integer id;

	private String userName;

	private String userLoginName;

	private String accessToken;

	public AuthUser() {

	}

	public AuthUser(UserDomain user) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.userLoginName = user.getUserLoginName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
