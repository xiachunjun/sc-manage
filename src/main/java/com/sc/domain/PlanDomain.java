package com.sc.domain;

import java.util.Date;

public class PlanDomain {
    private Integer id;

    /**
     * 责任人
     */
    private Integer refUserId;

    /**
     * 岗位
     */
    private Integer refPosiId;

    /**
     * 所属部门
     */
    private Integer refDeptId;

    /**
     * 计划名称
     */
    private String planName;

    /**
     * 计划类型
     */
    private Integer planType;

    /**
     * 计划创建日期
     */
    private Date planDate;

    /**
     * 执行人
     */
    private Integer planMainUser;

    /**
     * 计划完成度
     */
    private String rateOfProgress;

    /**
     * 完成情况
     */
    private String progressInfo;

    /**
     * 审核人
     */
    private Integer checkUser;

    /**
     * 审核时间
     */
    private Date checkTime;

    /**
     * 0-失效；1-初始；2-待领导审批；3-领导审核通过待执行人执行；4-领导审核不通过；5-执行人执行完成
     */
    private Integer dataState;

    private Integer dataVersion;

    /**
     * 创建人
     */
    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getRefDeptId() {
        return refDeptId;
    }

    public void setRefDeptId(Integer refDeptId) {
        this.refDeptId = refDeptId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Integer getPlanMainUser() {
        return planMainUser;
    }

    public void setPlanMainUser(Integer planMainUser) {
        this.planMainUser = planMainUser;
    }

    public String getRateOfProgress() {
        return rateOfProgress;
    }

    public void setRateOfProgress(String rateOfProgress) {
        this.rateOfProgress = rateOfProgress == null ? null : rateOfProgress.trim();
    }

    public String getProgressInfo() {
        return progressInfo;
    }

    public void setProgressInfo(String progressInfo) {
        this.progressInfo = progressInfo == null ? null : progressInfo.trim();
    }

    public Integer getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(Integer checkUser) {
        this.checkUser = checkUser;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    public Integer getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}