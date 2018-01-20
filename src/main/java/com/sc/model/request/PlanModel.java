package com.sc.model.request;

import java.util.Date;

public class PlanModel {

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
	/**责任人*/
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
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	
}
