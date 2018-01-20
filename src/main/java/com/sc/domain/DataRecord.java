package com.sc.domain;

import java.util.Date;

public class DataRecord {

	private Integer id;
	
	private String refDeptCode;
	
	/**数据类型（1-默认）*/
	private Integer recordType;
	
	/**数据时间*/
	private Date recordTime;
	
	/**指标名称*/
	private String recordName;
	
	/**计量单位（1-百分比，2-亿元，3-美元，4-元）*/
	private Integer recordUnit;
	
	/**指标值*/
	private Float recordValue;
	
	private Float targetValue;
	
	/**完成度*/
	private String rateOfProgress;
	
	/**完成情况*/
	private String progressInfo;
	
	private String recordMemo;
	
	private Integer dataState;

    private Integer dataVersion;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

	public Integer getId() {
		return id;
	}

	public String getRefDeptCode() {
		return refDeptCode;
	}

	public Integer getRecordType() {
		return recordType;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public String getRecordName() {
		return recordName;
	}

	public Integer getRecordUnit() {
		return recordUnit;
	}

	public Float getRecordValue() {
		return recordValue;
	}

	public Float getTargetValue() {
		return targetValue;
	}

	public String getRateOfProgress() {
		return rateOfProgress;
	}

	public String getProgressInfo() {
		return progressInfo;
	}

	public String getRecordMemo() {
		return recordMemo;
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

	public void setRefDeptCode(String refDeptCode) {
		this.refDeptCode = refDeptCode;
	}

	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public void setRecordUnit(Integer recordUnit) {
		this.recordUnit = recordUnit;
	}

	public void setRecordValue(Float recordValue) {
		this.recordValue = recordValue;
	}

	public void setTargetValue(Float targetValue) {
		this.targetValue = targetValue;
	}

	public void setRateOfProgress(String rateOfProgress) {
		this.rateOfProgress = rateOfProgress;
	}

	public void setProgressInfo(String progressInfo) {
		this.progressInfo = progressInfo;
	}

	public void setRecordMemo(String recordMemo) {
		this.recordMemo = recordMemo;
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
