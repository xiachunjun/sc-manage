package com.sc.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 部门
 */
public class Department {
	
	private Integer id;
	
	/**所属企业，企业表业务主键*/
	private String refCompanyCode;
	
	/**部门业务主键*/
	private String departmentCode;
	
	/**部门名称*/
	private String departmentName;
	
	/**部门类型*/
	private String departmentType;
	
	/**部门级别*/
	private String departmentLevel;
	
	/**上级部门code*/
	private String parentDepartmentCode;
	
	@JsonIgnore
	private String dataMemo;
	
	@JsonIgnore
	private Integer dataState;

	@JsonIgnore
    private Integer dataVersion;

	@JsonIgnore
    private String createUser;

	@JsonIgnore
    private String updateUser;

	@JsonIgnore
    private Date createTime;

	@JsonIgnore
    private Date updateTime;

	public Integer getId() {
		return id;
	}

	public String getRefCompanyCode() {
		return refCompanyCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public String getDepartmentType() {
		return departmentType;
	}

	public String getDepartmentLevel() {
		return departmentLevel;
	}

	public String getParentDepartmentCode() {
		return parentDepartmentCode;
	}

	public void setParentDepartmentCode(String parentDepartmentCode) {
		this.parentDepartmentCode = parentDepartmentCode;
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

	public void setRefCompanyCode(String refCompanyCode) {
		this.refCompanyCode = refCompanyCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public void setDepartmentLevel(String departmentLevel) {
		this.departmentLevel = departmentLevel;
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
