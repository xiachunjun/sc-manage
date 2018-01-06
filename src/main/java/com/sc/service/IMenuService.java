package com.sc.service;

import java.util.Map;

public interface IMenuService {

	/**
	 * 查询菜单列表
	 * @return
	 */
	Map<String, Object> queryParentMenutList();

	/**
	 * 根据parentMenuCode, 查询子菜单列表
	 * @param parentMenuCode
	 * @return
	 */
	Map<String, Object> queryMenutListByParentMenuCode(String parentMenuCode);

}
