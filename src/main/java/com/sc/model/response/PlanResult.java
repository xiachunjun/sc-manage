package com.sc.model.response;

import java.util.Date;

public class PlanResult {

	private Integer id;
	
	private Integer refPlanId;

    private String deptName;
    private String userName;
    private String userLoginName;

    private Integer planMainUser;
    
    private String updateUser;
    
    private String rateOfProgress;
    private String rateOfProgressName;
    
    private String progressInfo;
    
    private Date planDate;
    private String posiName;
    
	public Integer getId() {
		return id;
	}

	public Integer getRefPlanId() {
		return refPlanId;
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

	public String getRateOfProgressName() {
		return rateOfProgressName;
	}

	public void setRateOfProgressName(String rateOfProgressName) {
		this.rateOfProgressName = rateOfProgressName;
	}
    
	
}
