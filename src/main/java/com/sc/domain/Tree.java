package com.sc.domain;

import java.io.Serializable;

public class Tree implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer tid;
	
	private Integer pid;
	
	private String name;
	
	private String url;
	
	private Boolean isParent;
	
	/**1正常， 0无效*/
	private Integer dataState;


	public Integer getTid() {
		return tid;
	}

	public Integer getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public Integer getDataState() {
		return dataState;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	

}
