package com.sc.model.response;

public class DutyResult {

	/**责任人*/
	private Integer userId;
	private String userName;
	
	/**部门*/
	private Integer deptId;
	private String deptName;
	
	/**岗位*/
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
