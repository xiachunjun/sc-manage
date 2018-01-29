package com.sc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import com.sc.domain.base.BaseDomain;

@Table(name="sc_plan_details")
public class PlanDetailDomain extends BaseDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;

    /**
     * sc_plans表的id
     */
    private Integer refPlanId;

    /**
     * 工作类型 : 1常规，2计划外，3重点
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

    public void setRefPlanId(Integer refPlanId) {
        this.refPlanId = refPlanId;
    }

    public Integer getDetailType() {
        return detailType;
    }

    public void setDetailType(Integer detailType) {
        this.detailType = detailType;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent == null ? null : detailContent.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}