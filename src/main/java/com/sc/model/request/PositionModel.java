package com.sc.model.request;

public class PositionModel {

	/**部门code*/
	private String refDepartmentCode;
	
	/**岗位名称*/
	private String positionName;
	
	/**责任人*/
	private String dutyPerson;

	public String getRefDepartmentCode() {
		return refDepartmentCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public String getDutyPerson() {
		return dutyPerson;
	}

	public void setRefDepartmentCode(String refDepartmentCode) {
		this.refDepartmentCode = refDepartmentCode;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public void setDutyPerson(String dutyPerson) {
		this.dutyPerson = dutyPerson;
	}
	
	
}
