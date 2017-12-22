package com.sc.domain;

import java.util.Date;

/**
 * 规章制度
 */
public class Bylaw {

	private Integer id;
	
	/**业务主键*/
	private String bylawsCode;
	
	/**规则制度分类*/
	private String bylawsCategory;
	
	/**名称*/
	private String bylawsName;
	
	/**编号*/
	private String bylawsNo;
	
	/**发文文号*/
	private String articleNo;
	
	/**发文时间*/
	private Date articleTime;
	
	/**规章制度内容*/
	private String bylawsContent;
	
	/**如果不直接保存内容，则以文件或页面的形式保存*/
	private String fileUrl;
	
	private Integer dataState;

    private Integer dataVersion;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    
	public Integer getId() {
		return id;
	}

	public String getBylawsCode() {
		return bylawsCode;
	}

	public String getBylawsCategory() {
		return bylawsCategory;
	}

	public String getBylawsName() {
		return bylawsName;
	}

	public String getBylawsNo() {
		return bylawsNo;
	}

	public String getArticleNo() {
		return articleNo;
	}

	public Date getArticleTime() {
		return articleTime;
	}

	public String getBylawsContent() {
		return bylawsContent;
	}

	public String getFileUrl() {
		return fileUrl;
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

	public void setBylawsCode(String bylawsCode) {
		this.bylawsCode = bylawsCode;
	}

	public void setBylawsCategory(String bylawsCategory) {
		this.bylawsCategory = bylawsCategory;
	}

	public void setBylawsName(String bylawsName) {
		this.bylawsName = bylawsName;
	}

	public void setBylawsNo(String bylawsNo) {
		this.bylawsNo = bylawsNo;
	}

	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}

	public void setArticleTime(Date articleTime) {
		this.articleTime = articleTime;
	}

	public void setBylawsContent(String bylawsContent) {
		this.bylawsContent = bylawsContent;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
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
