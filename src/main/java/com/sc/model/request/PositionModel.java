package com.sc.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sc.support.ValidatedGroup1;
import com.sc.support.ValidatedGroup2;
import com.sc.support.ValidatedGroup3;

public class PositionModel {
	@NotNull(message="ID不能为空",groups={ValidatedGroup1.class})
	private Integer id;

	/**
	 * 所属部门
	 */
	@NotNull(message="部门ID不能为空" ,groups={ValidatedGroup2.class,ValidatedGroup3.class})
	private Integer refDeptId;

	/**
	 * 岗位名称
	 */
	@NotBlank(message="岗位名称不能为空" ,groups={ValidatedGroup2.class})
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
