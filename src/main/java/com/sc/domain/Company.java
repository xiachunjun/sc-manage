package com.sc.domain;

import java.util.Date;

/**
 * 企业
 */
public class Company {

	private Integer id;
	
	/**业务主键*/
	private String companyCode;
	
	/**公司名称*/
	private String companyName;
	
	/**类型*/
	private String companyType;
	
	/**组织结构代码*/
	private String orgCode;
	
	/**社会统一征信码*/
	private String creditCode;
	
	/**法人姓名*/
	private String legalPersonName;
	
	/**法人身份证*/
	private String legalPersonId;
	
	/**备注*/
	private String dataMemo;

	private Integer dataState;

    private Integer dataVersion;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;
	
    
	public Integer getId() {
		return id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public String getLegalPersonId() {
		return legalPersonId;
	}

	public String getDataMemo() {
		return dataMemo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public void setLegalPersonId(String legalPersonId) {
		this.legalPersonId = legalPersonId;
	}

	public void setDataMemo(String dataMemo) {
		this.dataMemo = dataMemo;
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
