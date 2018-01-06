package com.sc.domain;

import java.util.Date;

public class Article {

	private Integer id;
	
	/**联系人*/
	private String articleLinkUser;
	
	/**联系人手机号*/
	private String articleLinkUserPhone;
	
	/**签发人*/
	private String articleSignUser;
	
	/**保密级别*/
	private String secrecyLevel;
	
	/**文章时间*/
	private Date articleTime;
	
	/**标题*/
	private String articleTitle;
	
	/**内容*/
	private String articleContent;
	
	/**待审核0， 审核通过1， 审核不通过2*/
	private Integer dataState;

    private Integer dataVersion;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    
	public Integer getId() {
		return id;
	}

	public String getArticleLinkUser() {
		return articleLinkUser;
	}

	public String getArticleSignUser() {
		return articleSignUser;
	}

	public String getArticleLinkUserPhone() {
		return articleLinkUserPhone;
	}

	public void setArticleLinkUserPhone(String articleLinkUserPhone) {
		this.articleLinkUserPhone = articleLinkUserPhone;
	}

	public String getSecrecyLevel() {
		return secrecyLevel;
	}

	public Date getArticleTime() {
		return articleTime;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public Integer getDataState() {
		return dataState;
	}

	public Integer getDataVersion() {
		return dataVersion;
	}

	public String getCreateUser() {
		return createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setArticleLinkUser(String articleLinkUser) {
		this.articleLinkUser = articleLinkUser;
	}

	public void setArticleSignUser(String articleSignUser) {
		this.articleSignUser = articleSignUser;
	}

	public void setSecrecyLevel(String secrecyLevel) {
		this.secrecyLevel = secrecyLevel;
	}

	public void setArticleTime(Date articleTime) {
		this.articleTime = articleTime;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	public void setDataVersion(Integer dataVersion) {
		this.dataVersion = dataVersion;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
    
}
