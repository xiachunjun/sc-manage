package com.sc.model.request;

import java.util.Date;

public class ArticleModel {
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
		this.articleLinkUser = articleLinkUser;
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
		this.articleLinkUserPhone = articleLinkUserPhone;
	}

	public String getArticleSignUser() {
		return articleSignUser;
	}

	public void setArticleSignUser(String articleSignUser) {
		this.articleSignUser = articleSignUser;
	}

	public String getSignUserCheckState() {
		return signUserCheckState;
	}

	public void setSignUserCheckState(String signUserCheckState) {
		this.signUserCheckState = signUserCheckState;
	}

	public String getSecrecyLevel() {
		return secrecyLevel;
	}

	public void setSecrecyLevel(String secrecyLevel) {
		this.secrecyLevel = secrecyLevel;
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
		this.articleTitle = articleTitle;
	}

}
