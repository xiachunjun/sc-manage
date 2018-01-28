package com.sc.model.response;

import java.util.Date;

public class PlanDetailResult {

	private Integer id;
	
	private Integer refPlanId;

    /**工作类型 : 1常规，2计划外，3重点 */
    private Integer detailType;

    /**计划内容*/
    private String detailContent;

    /**开始时间*/
    private Date beginTime;
    
    /** 结束时间 */
    private Date endTime;
	
    private String deptName;
    private String userName;
    private String userLoginName;

    private Integer planMainUser;
    private String updateUser;
    private String rateOfProgress;
    private String progressInfo;
    
    private Date planDate;
    private String posiName;
    
	public Integer getId() {
		return id;
	}

	public Integer getRefPlanId() {
		return refPlanId;
	}

	public Integer getDetailType() {
		return detailType;
	}

	public String getDetailContent() {
		return detailContent;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRefPlanId(Integer refPlanId) {
		this.refPlanId = refPlanId;
	}

	public void setDetailType(Integer detailType) {
		this.detailType = detailType;
	}

	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getDeptName() {
		return deptName;
	}

	public Integer getPlanMainUser() {
		return planMainUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public String getRateOfProgress() {
		return rateOfProgress;
	}

	public String getProgressInfo() {
		return progressInfo;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setPlanMainUser(Integer planMainUser) {
		this.planMainUser = planMainUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setRateOfProgress(String rateOfProgress) {
		this.rateOfProgress = rateOfProgress;
	}

	public void setProgressInfo(String progressInfo) {
		this.progressInfo = progressInfo;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public String getPosiName() {
		return posiName;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public void setPosiName(String posiName) {
		this.posiName = posiName;
	}
    
	
}
