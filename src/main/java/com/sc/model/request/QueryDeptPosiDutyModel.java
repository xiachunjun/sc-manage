package com.sc.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class QueryDeptPosiDutyModel {

	@NotNull(message = "部门或岗位id不能为空")
	private Integer qId;

	@NotBlank(message = "部门或岗位类型不能为空")
	private String type;

	private Integer dutyLevel;

	public Integer getqId() {
		return qId;
	}

	public String getType() {
		return type;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDutyLevel() {
		return dutyLevel;
	}

	public void setDutyLevel(Integer dutyLevel) {
		this.dutyLevel = dutyLevel;
	}

}
