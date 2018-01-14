package com.sc.model.response;

public class MenuResult {

	private Integer id;
	
	private String menuCode;
	
	private String menuName;
	
	private String menuLevel;
	
	private String parentCode;
	
	private String relResouceCode;
	
	private String resName;
	
	private String resUrl;
	
	private Integer resType;
	
	private Integer resLevel;
	
	private Integer dataState;

	public Integer getId() {
		return id;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getMenuLevel() {
		return menuLevel;
	}

	public String getParentCode() {
		return parentCode;
	}

	public String getRelResouceCode() {
		return relResouceCode;
	}

	public String getResName() {
		return resName;
	}

	public String getResUrl() {
		return resUrl;
	}

	public Integer getResType() {
		return resType;
	}

	public Integer getResLevel() {
		return resLevel;
	}

	public Integer getDataState() {
		return dataState;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public void setRelResouceCode(String relResouceCode) {
		this.relResouceCode = relResouceCode;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public void setResType(Integer resType) {
		this.resType = resType;
	}

	public void setResLevel(Integer resLevel) {
		this.resLevel = resLevel;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	
	
}
