package com.sc.model.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.sc.domain.PlanDetailDomain;
import com.sc.support.ValidatedGroup1;

public class PlanModel {
	
	@NotNull(message="ID不能为空",groups={ValidatedGroup1.class})
	private Integer id;
	
//	/** 责任人ID */
//	private Integer refUserId;
//	/** 岗位ID */
//	private Integer refPosiId;
//	/** 所属部门ID */
//	private Integer refDeptId;
//	/** 计划名称 : 暂时没用  */
//	private String planName;
//	/** 计划类型 : 暂时没用  */
//	private Integer planType;
	
	/** 计划创建日期 */
	private Date planDate;
	private String planDateStr;
	
	/** 计划完成度 */
	private String rateOfProgress;
	
	/** 完成情况 */
	private String progressInfo;
	
	//plan_detail内容
	private List<PlanDetailDomain> planDetailList;

	
	public Integer getId() {
		return id;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public String getPlanDateStr() {
		return planDateStr;
	}

	public String getRateOfProgress() {
		return rateOfProgress;
	}

	public String getProgressInfo() {
		return progressInfo;
	}

	public List<PlanDetailDomain> getPlanDetailList() {
		return planDetailList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public void setPlanDateStr(String planDateStr) {
		this.planDateStr = planDateStr;
	}

	public void setRateOfProgress(String rateOfProgress) {
		this.rateOfProgress = rateOfProgress;
	}

	public void setProgressInfo(String progressInfo) {
		this.progressInfo = progressInfo;
	}

	public void setPlanDetailList(List<PlanDetailDomain> planDetailList) {
		this.planDetailList = planDetailList;
	}
	
	
}
