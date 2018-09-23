package com.sc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import com.sc.domain.base.BaseDomain;

@Table(name="sc_data_records")
public class DataRecordDomain extends BaseDomain implements Serializable{

	private static final long serialVersionUID = 1L;

	/**所属部门*/
	private Integer refDeptId;
	
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
	
	/**目标值*/
	private Float targetValue;
	
	/**完成度*/
	private String rateOfProgress;
	
	/**完成情况*/
	private String progressInfo;
	
	/**备注*/
	private String recordMemo;

	
	public Integer getRefDeptId() {
		return refDeptId;
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

	public void setRefDeptId(Integer refDeptId) {
		this.refDeptId = refDeptId;
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
	
	
}
