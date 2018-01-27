package com.sc.model.request;

import javax.validation.constraints.NotNull;

/**
 * 所有根据ID明细查询，删除都使用该model
 *
 */
public class IDModel {
	@NotNull(message = "id不能为空")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
