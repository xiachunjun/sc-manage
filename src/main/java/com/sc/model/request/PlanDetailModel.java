package com.sc.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sc.support.ValidatedGroup1;
import com.sc.support.ValidatedGroup2;

public class PlanDetailModel {

	@NotNull(message="ID不能为空",groups={ValidatedGroup1.class})
	private Integer id;
	
	@NotNull(message="planId不能为空",groups={ValidatedGroup2.class})
	private Integer refPlanId;

    /**
     * 工作类型
     */
	@NotNull(message="工作类型不能为空",groups={ValidatedGroup2.class})
    private Integer detailType;

    /**
     * 计划内容
     */
    @NotBlank(message="工作计划内容不能为空",groups={ValidatedGroup2.class})
    private String detailContent;

    /**
     * 开始时间
     */
    @NotBlank(message="开始时间不能为空",groups={ValidatedGroup2.class})
    private String beginTimeStr;

    /**
     * 结束时间
     */
    @NotBlank(message="结束时间不能为空",groups={ValidatedGroup2.class})
    private String endTimeStr;

    /**审核状态：0-失效；1-初始；2-待领导审批；3-领导审核通过待执行人执行；4-领导审核不通过；5-执行人执行完成*/
    @NotNull(message="审核状态不能为空",groups={ValidatedGroup2.class})
    private Integer planDataState;
    
    
	public Integer getRefPlanId() {
		return refPlanId;
	}

	public Integer getDetailType() {
		return detailType;
	}

	public String getDetailContent() {
		return detailContent;
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

	public Integer getId() {
		return id;
	}

	public String getBeginTimeStr() {
		return beginTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBeginTimeStr(String beginTimeStr) {
		this.beginTimeStr = beginTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public Integer getPlanDataState() {
		return planDataState;
	}

	public void setPlanDataState(Integer planDataState) {
		this.planDataState = planDataState;
	}
    
    
}
