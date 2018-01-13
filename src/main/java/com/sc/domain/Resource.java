package com.sc.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Resource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String resCode;

	private String resName;
	
	private String resUrl;
	
	private Integer resType;
	
	private Integer resLevel;
	
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

	public String getResCode() {
		return resCode;
	}

	public String getResName() {
		return resName;
	}

	public String getResUrl() {
		return resUrl;
	}

	public Integer getResType() {
		return resType;
	}

	public Integer getResLevel() {
		return resLevel;
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

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public void setResType(Integer resType) {
		this.resType = resType;
	}

	public void setResLevel(Integer resLevel) {
		this.resLevel = resLevel;
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
