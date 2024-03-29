package com.sc.domain;

import java.io.Serializable;

import javax.persistence.Table;

import com.sc.domain.base.BaseDomain;

@Table(name="sc_duty")
public class DutyDomain extends BaseDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;

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

    /**
     * 父code
     */
    private Integer parentId;

    private String dataMemo;

    public Integer getRefDeptId() {
        return refDeptId;
    }

    public void setRefDeptId(Integer refDeptId) {
        this.refDeptId = refDeptId;
    }

    public Integer getRefPosiId() {
        return refPosiId;
    }

    public void setRefPosiId(Integer refPosiId) {
        this.refPosiId = refPosiId;
    }

    public String getDutyType() {
        return dutyType;
    }

    public void setDutyType(String dutyType) {
        this.dutyType = dutyType == null ? null : dutyType.trim();
    }

    public String getDutyLevel() {
        return dutyLevel;
    }

    public void setDutyLevel(String dutyLevel) {
        this.dutyLevel = dutyLevel == null ? null : dutyLevel.trim();
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName == null ? null : dutyName.trim();
    }

    public String getDutyIntroduce() {
        return dutyIntroduce;
    }

    public void setDutyIntroduce(String dutyIntroduce) {
        this.dutyIntroduce = dutyIntroduce == null ? null : dutyIntroduce.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDataMemo() {
        return dataMemo;
    }

    public void setDataMemo(String dataMemo) {
        this.dataMemo = dataMemo == null ? null : dataMemo.trim();
    }

   
}