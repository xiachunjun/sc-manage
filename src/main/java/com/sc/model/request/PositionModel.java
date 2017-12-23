package com.sc.model.request;

public class PositionModel {

	/**部门code*/
	private String refDepartmentCode;
	
	/**岗位名称*/
	private String positionName;
	
	/**责任人(用户code)*/
	private String refUserCode;

	public String getRefDepartmentCode() {
		return refDepartmentCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setRefDepartmentCode(String refDepartmentCode) {
		this.refDepartmentCode = refDepartmentCode;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getRefUserCode() {
		return refUserCode;
	}

	public void setRefUserCode(String refUserCode) {
		this.refUserCode = refUserCode;
	}

	
	
}
