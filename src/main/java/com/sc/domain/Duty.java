package com.sc.domain;

import java.util.Date;

public class Duty {

	private Integer id;
	  
	private String dutyCode;
	
	private String refDepartmentCode;
	
	private String refPositionCode;
	
	/**职责类型（DEPT-部门职责，POSI-岗位职责）*/
	private String dutyType;
	
	/**级别（1-一级职责，2-二级职责）*/
	private String dutyLevel;
	
	/**名称*/
	private String dutyName;
	
	/**描述*/
	private String dutyIntroduce;
	
	/**父code*/
	private String parentCode;
	
	private String dataMemo;
	
	private Integer dataState;

    private Integer dataVersion;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    
	public Integer getId() {
		return id;
	}

	public String getDutyCode() {
		return dutyCode;
	}

	public String getRefDepartmentCode() {
		return refDepartmentCode;
	}

	public String getRefPositionCode() {
		return refPositionCode;
	}

	public String getDutyType() {
		return dutyType;
	}

	public String getDutyLevel() {
		return dutyLevel;
	}

	public String getDutyName() {
		return dutyName;
	}

	public String getDutyIntroduce() {
		return dutyIntroduce;
	}

	public String getParentCode() {
		return parentCode;
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

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	public void setRefDepartmentCode(String refDepartmentCode) {
		this.refDepartmentCode = refDepartmentCode;
	}

	public void setRefPositionCode(String refPositionCode) {
		this.refPositionCode = refPositionCode;
	}

	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}

	public void setDutyLevel(String dutyLevel) {
		this.dutyLevel = dutyLevel;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public void setDutyIntroduce(String dutyIntroduce) {
		this.dutyIntroduce = dutyIntroduce;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
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

    
}
