package com.sc.domain;

public class Menu {

	private Integer id;
	
	private String menuCode;
	
	private String parentMenuCode;
	
	private String menuName;
	
	private String menuUrl;
	
	private Integer menuSortOrder;
	
	private Integer isParent;
	
	/**1正常， 0无效*/
	private Integer dataState;

	
	public Integer getId() {
		return id;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public String getParentMenuCode() {
		return parentMenuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public Integer getMenuSortOrder() {
		return menuSortOrder;
	}

	public Integer getIsParent() {
		return isParent;
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

	public void setParentMenuCode(String parentMenuCode) {
		this.parentMenuCode = parentMenuCode;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public void setMenuSortOrder(Integer menuSortOrder) {
		this.menuSortOrder = menuSortOrder;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	
}
