package com.sc.model.request;

import org.hibernate.validator.constraints.NotBlank;

public class DepartmentModel {
	private Integer id;

	/**
	 * 所属公司
	 */
	private String refCpnCode;

	/**
	 * 部门名称
	 */
	@NotBlank(message="部门名称不能为空")
	private String deptName;

	/**
	 * 类型
	 */
	private Integer deptType;

	/**
	 * 级别
	 */
	private Integer deptLevel;

	/**
	 * 上级部门code
	 */
	private Integer parentId;

	/**
	 * 备注
	 */
	@NotBlank(message="备注不能为空")
	private String dataMemo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRefCpnCode() {
		return refCpnCode;
	}

	public void setRefCpnCode(String refCpnCode) {
		this.refCpnCode = refCpnCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDeptType() {
		return deptType;
	}

	public void setDeptType(Integer deptType) {
		this.deptType = deptType;
	}

	public Integer getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(Integer deptLevel) {
		this.deptLevel = deptLevel;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getDataMemo() {
		return dataMemo;
	}

	public void setDataMemo(String dataMemo) {
		this.dataMemo = dataMemo;
	}

}
