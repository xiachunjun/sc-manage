package com.sc.model.request;

public class PositionModel {

	// 用于修改操作时传入后端，表示记录id
	private Integer id;

	/** 部门code */
	private String departmentCode;

	/** 岗位名称 */
	private String positionName;

	/** 责任人(用户code) */
	private String userCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
