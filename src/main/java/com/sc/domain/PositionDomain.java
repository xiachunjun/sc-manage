package com.sc.domain;

import java.io.Serializable;

import javax.persistence.Table;

import com.sc.domain.base.BaseDomain;

@Table(name="sc_positions")
public class PositionDomain extends BaseDomain implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * 所属部门
     */
    private Integer refDeptId;

    /**
     * 岗位名称
     */
    private String posiName;

    /**
     * 岗位描述
     */
    private String posiIntroduce;

    /**
     * 备注
     */
    private String dataMemo;


    public Integer getRefDeptId() {
        return refDeptId;
    }

    public void setRefDeptId(Integer refDeptId) {
        this.refDeptId = refDeptId;
    }

    public String getPosiName() {
        return posiName;
    }

    public void setPosiName(String posiName) {
        this.posiName = posiName == null ? null : posiName.trim();
    }

    public String getPosiIntroduce() {
        return posiIntroduce;
    }

    public void setPosiIntroduce(String posiIntroduce) {
        this.posiIntroduce = posiIntroduce == null ? null : posiIntroduce.trim();
    }

    public String getDataMemo() {
        return dataMemo;
    }

    public void setDataMemo(String dataMemo) {
        this.dataMemo = dataMemo == null ? null : dataMemo.trim();
    }

   
}