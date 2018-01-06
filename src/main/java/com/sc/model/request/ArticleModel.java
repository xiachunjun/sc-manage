package com.sc.model.request;


public class ArticleModel {

	/**联系人*/
	private String articleLinkUser;
	
	/**联系人手机号*/
	private String articleLinkUserPhone;
	
	/**签发人*/
	private String articleSignUser;
	
	/**保密级别*/
	private String secrecyLevel;
	
	/**文章时间*/
	private String artTime;
	
	/**标题*/
	private String articleTitle;
	
	/**内容*/
	private String articleContent;

	//附加值
	private String userLoginName;
	
	
	public String getArticleLinkUser() {
		return articleLinkUser;
	}

	public String getArticleLinkUserPhone() {
		return articleLinkUserPhone;
	}

	public String getArticleSignUser() {
		return articleSignUser;
	}

	public String getSecrecyLevel() {
		return secrecyLevel;
	}

	public String getArtTime() {
		return artTime;
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

	public void setArticleLinkUserPhone(String articleLinkUserPhone) {
		this.articleLinkUserPhone = articleLinkUserPhone;
	}

	public void setArticleSignUser(String articleSignUser) {
		this.articleSignUser = articleSignUser;
	}

	public void setSecrecyLevel(String secrecyLevel) {
		this.secrecyLevel = secrecyLevel;
	}

	public void setArtTime(String artTime) {
		this.artTime = artTime;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	
	
}
