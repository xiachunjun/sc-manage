package com.sc.domain;

import java.util.Date;

public class Plan {

	private Integer id;
	
	/**所属部门*/
	private String refDept;
	/**责任人*/
	private String refUser;
	/**岗位*/
	private String refPosition;
	/**计划名称*/
	private String planName;
	/**计划类型*/
	private Integer planType;
	/**计划创建日期*/
	private Date planDate;
	/**执行人*/
	private String planMainPerson;
	/**计划内容*/
	private String planContent;
	/**计划开始时间*/
	private Date planBeginTime;
	/**计划结束时间*/
	private Date planEndTime;
	/**计划完成度*/
	private String rateOfProgress;
	/**完成情况*/
	private String progressInfo;
	/**审核人*/
	private String checkUser;
	/**审核时间*/
	private Date checkTime;
	
	private Integer dataState;

    private Integer dataVersion;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

	public Integer getId() {
		return id;
	}

	public String getRefDept() {
		return refDept;
	}

	public String getRefUser() {
		return refUser;
	}

	public String getRefPosition() {
		return refPosition;
	}

	public String getPlanName() {
		return planName;
	}

	public Integer getPlanType() {
		return planType;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public String getPlanMainPerson() {
		return planMainPerson;
	}

	public String getPlanContent() {
		return planContent;
	}

	public Date getPlanBeginTime() {
		return planBeginTime;
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public String getRateOfProgress() {
		return rateOfProgress;
	}

	public String getProgressInfo() {
		return progressInfo;
	}

	public String getCheckUser() {
		return checkUser;
	}

	public Date getCheckTime() {
		return checkTime;
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

	public void setRefDept(String refDept) {
		this.refDept = refDept;
	}

	public void setRefUser(String refUser) {
		this.refUser = refUser;
	}

	public void setRefPosition(String refPosition) {
		this.refPosition = refPosition;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public void setPlanType(Integer planType) {
		this.planType = planType;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public void setPlanMainPerson(String planMainPerson) {
		this.planMainPerson = planMainPerson;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	public void setPlanBeginTime(Date planBeginTime) {
		this.planBeginTime = planBeginTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public void setRateOfProgress(String rateOfProgress) {
		this.rateOfProgress = rateOfProgress;
	}

	public void setProgressInfo(String progressInfo) {
		this.progressInfo = progressInfo;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
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
