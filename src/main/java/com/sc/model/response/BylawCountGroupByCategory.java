package com.sc.model.response;

/**
 * 按规章制度类型分组，查询各类型的数量 的结果类
 *
 */
public class BylawCountGroupByCategory {

	private String bylawsCategory;
	
	private Integer count;

	public String getBylawsCategory() {
		return bylawsCategory;
	}

	public Integer getCount() {
		return count;
	}

	public void setBylawsCategory(String bylawsCategory) {
		this.bylawsCategory = bylawsCategory;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
