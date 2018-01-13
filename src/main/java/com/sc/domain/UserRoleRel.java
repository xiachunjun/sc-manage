package com.sc.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRoleRel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String relUserCode;
	
	private String relRoleCode;
	
	private String dataMemo;
	
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

	public String getRelUserCode() {
		return relUserCode;
	}

	public String getRelRoleCode() {
		return relRoleCode;
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

	public void setRelUserCode(String relUserCode) {
		this.relUserCode = relUserCode;
	}

	public void setRelRoleCode(String relRoleCode) {
		this.relRoleCode = relRoleCode;
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
