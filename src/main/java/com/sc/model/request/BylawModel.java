package com.sc.model.request;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class BylawModel {

	private Integer id;
	
	/**规则制度分类*/
	@NotEmpty(message="规则制度分类不能为空")
	private String bylawsCategory;
	
	/**名称*/
	@NotEmpty(message="名称不能为空")
	private String bylawsName;
	
	/**编号*/
	@NotEmpty(message="编号不能为空")
	private String bylawsNo;
	
	/**发文文号*/
	@NotEmpty(message="发文文号不能为空")
	private String articleNo;
	
	/**发文时间*/
	private Date articleTime;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
}
