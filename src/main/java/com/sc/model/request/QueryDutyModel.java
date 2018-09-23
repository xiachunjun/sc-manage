package com.sc.model.request;

public class QueryDutyModel {

	private Integer userId; 
	
	private Integer deptId;
	
	private Integer posiId;

	public Integer getUserId() {
		return userId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public Integer getPosiId() {
		return posiId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public void setPosiId(Integer posiId) {
		this.posiId = posiId;
	}
	
}
