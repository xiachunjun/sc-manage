package com.sc.domain;

import java.io.Serializable;

import javax.persistence.Table;

import com.sc.domain.base.BaseDomain;

@Table(name="sc_departments")
public class DepartmentDomain extends BaseDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;

    /**
     * 所属公司
     */
    private String refCpnCode;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 类型
     */
    private Integer deptType;

    /**
     * 级别
     */
    private Integer deptLevel;

    /**
     * 上级部门code
     */
    private Integer parentId;

    /**
     * 备注
     */
    private String dataMemo;

    public String getRefCpnCode() {
        return refCpnCode;
    }

    public void setRefCpnCode(String refCpnCode) {
        this.refCpnCode = refCpnCode == null ? null : refCpnCode.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public Integer getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(Integer deptLevel) {
        this.deptLevel = deptLevel;
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