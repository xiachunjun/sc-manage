package com.sc.model.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.sc.support.ValidatedGroup2;

public class QueryPlanModel {

	/**所属部门*/
	private String refDept;
	
	/**计划创建日期*/
	private Date planDate;
	
	/**责任人*/
	private String planMainPerson;
	
	/**计划完成度*/
	private String rateOfProgress;
	
	//1待办计划，2在办计划，3我的计划
	@NotNull(message="tab不能为空",groups={ValidatedGroup2.class})
	private Integer tab;
	

	public String getRefDept() {
		return refDept;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public String getPlanMainPerson() {
		return planMainPerson;
	}

	public String getRateOfProgress() {
		return rateOfProgress;
	}

	public Integer getTab() {
		return tab;
	}

	public void setRefDept(String refDept) {
		this.refDept = refDept;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public void setPlanMainPerson(String planMainPerson) {
		this.planMainPerson = planMainPerson;
	}

	public void setRateOfProgress(String rateOfProgress) {
		this.rateOfProgress = rateOfProgress;
	}

	public void setTab(Integer tab) {
		this.tab = tab;
	}
	
	
}
