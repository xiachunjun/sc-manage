package com.sc.model.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.sc.support.ValidatedGroup1;
import com.sc.support.ValidatedGroup2;

public class QueryPlanModel {

	@NotNull(message="ID不能为空",groups={ValidatedGroup1.class})
	private Integer id;
	
	/**所属部门ID*/
	private Integer refDeptId;
	
	/**计划创建日期*/
	private Date planDate;
	private String planDateStr;
	
	/**责任人ID*/
	private String refUserId;
	
	/**计划完成度*/
	private String rateOfProgress;
	
	/**工作类型 : 1常规，2计划外，3重点*/
    private Integer detailType;
	
	//1待办计划，2在办计划，3我的计划
	@NotNull(message="tab不能为空",groups={ValidatedGroup2.class})
	private Integer tab;

	//进度节点
	private Integer dataState;

	
	public Integer getId() {
		return id;
	}

	public Integer getRefDeptId() {
		return refDeptId;
	}


	public Date getPlanDate() {
		return planDate;
	}


	public String getPlanDateStr() {
		return planDateStr;
	}


	public String getRefUserId() {
		return refUserId;
	}


	public String getRateOfProgress() {
		return rateOfProgress;
	}


	public Integer getDetailType() {
		return detailType;
	}


	public Integer getTab() {
		return tab;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setRefDeptId(Integer refDeptId) {
		this.refDeptId = refDeptId;
	}


	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}


	public void setPlanDateStr(String planDateStr) {
		this.planDateStr = planDateStr;
	}


	public void setRefUserId(String refUserId) {
		this.refUserId = refUserId;
	}


	public void setRateOfProgress(String rateOfProgress) {
		this.rateOfProgress = rateOfProgress;
	}


	public void setDetailType(Integer detailType) {
		this.detailType = detailType;
	}


	public void setTab(Integer tab) {
		this.tab = tab;
	}

	public Integer getDataState() {
		return dataState;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	

}
