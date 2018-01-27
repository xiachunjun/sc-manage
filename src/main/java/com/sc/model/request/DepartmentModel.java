package com.sc.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sc.support.ValidatedGroup1;
import com.sc.support.ValidatedGroup2;

public class DepartmentModel {
	
	@NotNull(message="ID不能为空",groups={ValidatedGroup1.class})
	private Integer id;

	/**
	 * 所属公司
	 */
	private String refCpnCode;

	/**
	 * 部门名称
	 */
	@NotBlank(message="部门名称不能为空",groups={ValidatedGroup2.class})
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
