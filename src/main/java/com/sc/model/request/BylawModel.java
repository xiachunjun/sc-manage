package com.sc.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class BylawModel {

	/**
	 * 规则制度分类
	 */
	@NotBlank(message = "规则制度分类不能为空")
	private String bylawsCategory;

	/**
	 * 名称
	 */
	@NotBlank(message = "名称不能为空")
	private String bylawsName;

	/**
	 * 编号
	 */
	@NotBlank(message = "编号不能为空")
	private String bylawsNo;

	/**
	 * 发文文号
	 */
	@NotBlank(message = "发文文号不能为空")
	private String articleNo;

	/**
	 * 发文时间
	 */
	private String artTime;

	@NotNull(message="文件不能为空")
	private MultipartFile file;

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

	public String getArtTime() {
		return artTime;
	}

	public void setArtTime(String artTime) {
		this.artTime = artTime;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
