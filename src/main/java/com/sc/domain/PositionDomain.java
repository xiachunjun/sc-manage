package com.sc.domain;

import java.util.Date;

public class PositionDomain {
    private Integer id;

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

    private Integer dataState;

    private Integer dataVersion;

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