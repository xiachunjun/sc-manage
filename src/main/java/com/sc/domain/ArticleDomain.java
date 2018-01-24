package com.sc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import com.sc.domain.base.BaseDomain;

@Table(name="sc_articles")
public class ArticleDomain extends BaseDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;

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

    /**
     * 内容
     */
    private String articleContent;

	public String getArticleLinkUser() {
		return articleLinkUser;
	}

	public Integer getLinkUserCheckState() {
		return linkUserCheckState;
	}

	public String getArticleLinkUserPhone() {
		return articleLinkUserPhone;
	}

	public String getArticleSignUser() {
		return articleSignUser;
	}

	public String getSignUserCheckState() {
		return signUserCheckState;
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

	public void setArticleLinkUser(String articleLinkUser) {
		this.articleLinkUser = articleLinkUser;
	}

	public void setLinkUserCheckState(Integer linkUserCheckState) {
		this.linkUserCheckState = linkUserCheckState;
	}

	public void setArticleLinkUserPhone(String articleLinkUserPhone) {
		this.articleLinkUserPhone = articleLinkUserPhone;
	}

	public void setArticleSignUser(String articleSignUser) {
		this.articleSignUser = articleSignUser;
	}

	public void setSignUserCheckState(String signUserCheckState) {
		this.signUserCheckState = signUserCheckState;
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


}