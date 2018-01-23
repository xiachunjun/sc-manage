package com.sc.model.request;

import java.util.Date;

public class DataRecordModel {

	private String refDeptCode;

	/** 数据时间 */
	private Date recordTime;

	/** 指标名称 */
	private String recordName;

	/** 计量单位（1-百分比，2-亿元，3-美元，4-元） */
	private Integer recordUnit;

	/** 指标值 */
	private Float recordValue;

	private Float targetValue;

	/** 完成度 */
	private String rateOfProgress;

	/** 完成情况 */
	private String progressInfo;

	private String recordMemo;

	public String getRefDeptCode() {
		return refDeptCode;
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

	public void setRefDeptCode(String refDeptCode) {
		this.refDeptCode = refDeptCode;
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
