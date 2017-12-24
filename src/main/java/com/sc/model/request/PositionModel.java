package com.sc.model.request;

public class PositionModel {

	//用于修改操作时传入后端，表示记录id
	private Integer id;
	
	/**部门code*/
	private String refDepartmentCode;
	
	/**岗位名称code*/
	private String positionCode;
	
	/**责任人(用户code)*/
	private String refUserCode;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRefDepartmentCode() {
		return refDepartmentCode;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public void setRefDepartmentCode(String refDepartmentCode) {
		this.refDepartmentCode = refDepartmentCode;
	}

	public String getRefUserCode() {
		return refUserCode;
	}

	public void setRefUserCode(String refUserCode) {
		this.refUserCode = refUserCode;
	}

	
	
}
