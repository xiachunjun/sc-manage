package com.sc.service;

import java.util.List;

import com.sc.domain.Resource;

public interface IRoleResourceRelService {

	/**
	 * 给角色赋予具体资源权限
	 * @param roleCode
	 * @param resourceCode
	 */
	void setResource2Role(String roleCode, String resourceCode);
	
	/**
	 * 根据用户code, 查询资源列表
	 * @param userCode
	 */
	List<Resource> queryResourceListByUserCode(String userCode);
	
	
}
