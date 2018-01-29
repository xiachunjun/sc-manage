package com.sc.model.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddPlanModel {

	/**
	 * 责任人
	 */
	private Integer refUserId;

	/**
	 * 岗位
	 */
	private Integer refPosiId;

	/**
	 * 所属部门
	 */
	private Integer refDeptId;

	/**
	 * 计划名称
	 */
	private String planName;

	/**
	 * 计划类型
	 */
	private Integer planType;

	/**
	 * 计划创建日期
	 */
	private Date planDate;

	/**
	 * 执行人
	 */
	private Integer planMainUser;

	/**
	 * 计划完成度
	 */
	private String rateOfProgress;

	/**
	 * 完成情况
	 */
	private String progressInfo;

	/**
	 * 审核人
	 */
	private Integer checkUser;

	/**
	 * 审核时间
	 */
	private Date checkTime;

	List<PlanDetailModel> planDetails = new ArrayList<PlanDetailModel>();

	public Integer getRefUserId() {
		return refUserId;
	}

	public void setRefUserId(Integer refUserId) {
		this.refUserId = refUserId;
	}

	public Integer getRefPosiId() {
		return refPosiId;
	}

	public void setRefPosiId(Integer refPosiId) {
		this.refPosiId = refPosiId;
	}

	public Integer getRefDeptId() {
		return refDeptId;
	}

	public void setRefDeptId(Integer refDeptId) {
		this.refDeptId = refDeptId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName == null ? null : planName.trim();
	}

	public Integer getPlanType() {
		return planType;
	}

	public void setPlanType(Integer planType) {
		this.planType = planType;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public Integer getPlanMainUser() {
		return planMainUser;
	}

	public void setPlanMainUser(Integer planMainUser) {
		this.planMainUser = planMainUser;
	}

	public String getRateOfProgress() {
		return rateOfProgress;
	}

	public void setRateOfProgress(String rateOfProgress) {
		this.rateOfProgress = rateOfProgress == null ? null : rateOfProgress.trim();
	}

	public String getProgressInfo() {
		return progressInfo;
	}

	public void setProgressInfo(String progressInfo) {
		this.progressInfo = progressInfo == null ? null : progressInfo.trim();
	}

	public Integer getCheckUser() {
		return checkUser;
	}

	public void setCheckUser(Integer checkUser) {
		this.checkUser = checkUser;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public List<PlanDetailModel> getPlanDetails() {
		return planDetails;
	}

	public void setPlanDetails(List<PlanDetailModel> planDetails) {
		this.planDetails = planDetails;
	}

}