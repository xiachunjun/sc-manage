package com.sc.domain;

import java.io.Serializable;

import javax.persistence.Table;

import com.sc.domain.base.BaseDomain;

@Table(name="sc_user_posi_rel")
public class UserPosiRelDomain extends BaseDomain implements Serializable{
    
	private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer refUserId;

    /**
     * 岗位id
     */
    private Integer refPosiId;

    public Integer getRefUserId() {
        return refUserId;
    }

    public void setRefUserId(Integer refUserId) {
        this.refUserId = refUserId;
    }

    public Integer getRefPosiId() {
        return refPosiId;
    }

    public void setRefPosiId(Integer refPosiId) {
        this.refPosiId = refPosiId;
    }

}