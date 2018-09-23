package com.sc.model.response;

public class UserInfoResult {
	
	private Integer userId;
	private String userName;
	
	private Integer deptId;
	private String deptName;
	
	private Integer posiId;
	private String posiName;
	
	
	public Integer getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public Integer getPosiId() {
		return posiId;
	}
	public String getPosiName() {
		return posiName;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public void setPosiId(Integer posiId) {
		this.posiId = posiId;
	}
	public void setPosiName(String posiName) {
		this.posiName = posiName;
	}

	
}
