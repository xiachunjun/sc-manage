package com.sc.model.request;

import java.util.Date;

public class PlanDetailModel {

	private Integer refPlanId;

    /**
     * 工作类型
     */
    private Integer detailType;

    /**
     * 计划内容
     */
    private String detailContent;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;

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
    
    
}
