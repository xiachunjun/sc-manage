package com.sc.model.request;

public class DutySaveModel {

	private Integer refUserId;
	
	private Integer refDeptId;

    private Integer refPosiId;

    /**
     * 职责类型（DEPT-部门职责，POSI-岗位职责）
     */
    private String dutyType;

    /**
     * 级别（1-一级职责，2-二级职责）
     */
    private String dutyLevel;

    /**
     * 名称
     */
    private String dutyName;

    /**
     * 描述
     */
    private String dutyIntroduce;

    
	public Integer getRefDeptId() {
		return refDeptId;
	}

	public Integer getRefPosiId() {
		return refPosiId;
	}

	public String getDutyType() {
		return dutyType;
	}

	public String getDutyLevel() {
		return dutyLevel;
	}

	public String getDutyName() {
		return dutyName;
	}

	public String getDutyIntroduce() {
		return dutyIntroduce;
	}

	public void setRefDeptId(Integer refDeptId) {
		this.refDeptId = refDeptId;
	}

	public void setRefPosiId(Integer refPosiId) {
		this.refPosiId = refPosiId;
	}

	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}

	public void setDutyLevel(String dutyLevel) {
		this.dutyLevel = dutyLevel;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public void setDutyIntroduce(String dutyIntroduce) {
		this.dutyIntroduce = dutyIntroduce;
	}

	public Integer getRefUserId() {
		return refUserId;
	}

	public void setRefUserId(Integer refUserId) {
		this.refUserId = refUserId;
	}
    
    
}
