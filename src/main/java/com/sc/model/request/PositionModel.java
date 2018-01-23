package com.sc.model.request;

public class PositionModel {
	private Integer id;

	/**
	 * 所属部门
	 */
	private Integer refDeptId;

	/**
	 * 岗位名称
	 */
	private String posiName;

	/**
	 * 岗位描述
	 */
	private String posiIntroduce;

	/**
	 * 备注
	 */
	private String dataMemo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRefDeptId() {
		return refDeptId;
	}

	public void setRefDeptId(Integer refDeptId) {
		this.refDeptId = refDeptId;
	}

	public String getPosiName() {
		return posiName;
	}

	public void setPosiName(String posiName) {
		this.posiName = posiName;
	}

	public String getPosiIntroduce() {
		return posiIntroduce;
	}

	public void setPosiIntroduce(String posiIntroduce) {
		this.posiIntroduce = posiIntroduce;
	}

	public String getDataMemo() {
		return dataMemo;
	}

	public void setDataMemo(String dataMemo) {
		this.dataMemo = dataMemo;
	}

}
