package com.sc.model.request;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BylawModel {
	
	private Integer id;
	
	/**
	 * 规则制度分类
	 */
	private String bylawsCategory;

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

	private MultipartFile file;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBylawsCategory() {
		return bylawsCategory;
	}

	public void setBylawsCategory(String bylawsCategory) {
		this.bylawsCategory = bylawsCategory;
	}

	public String getBylawsName() {
		return bylawsName;
	}

	public void setBylawsName(String bylawsName) {
		this.bylawsName = bylawsName;
	}

	public String getBylawsNo() {
		return bylawsNo;
	}

	public void setBylawsNo(String bylawsNo) {
		this.bylawsNo = bylawsNo;
	}

	public String getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
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
		this.fileUrl = fileUrl;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
