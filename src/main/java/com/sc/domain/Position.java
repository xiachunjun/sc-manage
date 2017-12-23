package com.sc.domain;

import java.util.Date;

/**
 * 岗位
 */
public class Position {

	private Integer id;
	
	/**所属部门, 部门表业务主键*/
	private String refDepartmentCode;
	
	/**职位表业务主键*/
	private String positionCode;
	
	/**职位*/
	private String positionName;
	
	/**负责人*/
	private String positionLeader;
	
	/**部门介绍*/
	private String positionIntroduce;
	
	/**备注*/
	private String dataMemo;
	  
	private Integer dataState;

    private Integer dataVersion;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    /**附加属性， 不属于表中字段*/
    private String departmentName;   //部门名称
    
    
	public Integer getId() {
		return id;
	}

	public String getRefDepartmentCode() {
		return refDepartmentCode;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public String getPositionLeader() {
		return positionLeader;
	}

	public void setPositionLeader(String positionLeader) {
		this.positionLeader = positionLeader;
	}

	public String getPositionIntroduce() {
		return positionIntroduce;
	}

	public String getDataMemo() {
		return dataMemo;
	}

	public Integer getDataState() {
		return dataState;
	}

	public Integer getDataVersion() {
		return dataVersion;
	}

	public String getCreateUser() {
		return createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRefDepartmentCode(String refDepartmentCode) {
		this.refDepartmentCode = refDepartmentCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public void setPositionIntroduce(String positionIntroduce) {
		this.positionIntroduce = positionIntroduce;
	}

	public void setDataMemo(String dataMemo) {
		this.dataMemo = dataMemo;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	public void setDataVersion(Integer dataVersion) {
		this.dataVersion = dataVersion;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
    
}
