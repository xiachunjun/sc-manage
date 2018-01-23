package com.sc.domain;

import java.util.Date;

public class BylawDomain {
    private Integer id;

    /**
     * 名称
     */
    private String bylawsName;

    /**
     * 编号
     */
    private String bylawsNo;

    /**
     * 发文文号
     */
    private String articleNo;

    /**
     * 发文时间
     */
    private Date articleTime;

    /**
     * （如果不直接保存内容，则以文件或页面的形式保存）
     */
    private String fileUrl;

    private String bylawsCategory;

    private Integer dataState;

    private Integer dataVersion;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    /**
     * 规章制度内容
     */
    private String bylawsContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBylawsName() {
        return bylawsName;
    }

    public void setBylawsName(String bylawsName) {
        this.bylawsName = bylawsName == null ? null : bylawsName.trim();
    }

    public String getBylawsNo() {
        return bylawsNo;
    }

    public void setBylawsNo(String bylawsNo) {
        this.bylawsNo = bylawsNo == null ? null : bylawsNo.trim();
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo == null ? null : articleNo.trim();
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getBylawsCategory() {
        return bylawsCategory;
    }

    public void setBylawsCategory(String bylawsCategory) {
        this.bylawsCategory = bylawsCategory == null ? null : bylawsCategory.trim();
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

    public String getBylawsContent() {
        return bylawsContent;
    }

    public void setBylawsContent(String bylawsContent) {
        this.bylawsContent = bylawsContent == null ? null : bylawsContent.trim();
    }
}