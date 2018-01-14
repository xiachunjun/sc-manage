package com.sc.service;

import com.sc.model.response.MenuResult;

public interface IMenuService {

	/**
	 * 查询顶级菜单列表
	 * @return
	 */
	MenuResult queryListByMenuLevel(String menuLevel);
	
	/**
	 * 根据父节点code，查询子菜单列表
	 * @return
	 */
	MenuResult queryListByParentCode(String parentCode);
	
}
