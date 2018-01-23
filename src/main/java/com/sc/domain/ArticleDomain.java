package com.sc.domain;

import java.util.Date;

public class ArticleDomain {
    private Integer id;

    /**
     * 联系人
     */
    private String articleLinkUser;

    /**
     * 联系人审核状态（0-初始，1-通过，2-拒绝）
     */
    private Integer linkUserCheckState;

    /**
     * 联系人手机号
     */
    private String articleLinkUserPhone;

    /**
     * 签发人
     */
    private String articleSignUser;

    /**
     * 签发状态（0-初始，1-通过，2-拒绝）
     */
    private String signUserCheckState;

    /**
     * 保密级别
     */
    private String secrecyLevel;

    /**
     * 文章时间
     */
    private Date articleTime;

    /**
     * 标题
     */
    private String articleTitle;

    private Integer dataState;

    private Integer dataVersion;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    /**
     * 内容
     */
    private String articleContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleLinkUser() {
        return articleLinkUser;
    }

    public void setArticleLinkUser(String articleLinkUser) {
        this.articleLinkUser = articleLinkUser == null ? null : articleLinkUser.trim();
    }

    public Integer getLinkUserCheckState() {
        return linkUserCheckState;
    }

    public void setLinkUserCheckState(Integer linkUserCheckState) {
        this.linkUserCheckState = linkUserCheckState;
    }

    public String getArticleLinkUserPhone() {
        return articleLinkUserPhone;
    }

    public void setArticleLinkUserPhone(String articleLinkUserPhone) {
        this.articleLinkUserPhone = articleLinkUserPhone == null ? null : articleLinkUserPhone.trim();
    }

    public String getArticleSignUser() {
        return articleSignUser;
    }

    public void setArticleSignUser(String articleSignUser) {
        this.articleSignUser = articleSignUser == null ? null : articleSignUser.trim();
    }

    public String getSignUserCheckState() {
        return signUserCheckState;
    }

    public void setSignUserCheckState(String signUserCheckState) {
        this.signUserCheckState = signUserCheckState == null ? null : signUserCheckState.trim();
    }

    public String getSecrecyLevel() {
        return secrecyLevel;
    }

    public void setSecrecyLevel(String secrecyLevel) {
        this.secrecyLevel = secrecyLevel == null ? null : secrecyLevel.trim();
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
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

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}