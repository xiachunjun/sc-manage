package com.sc.service;

import java.util.Map;

public interface ITreeService {

	/**
	 * 查询菜单列表
	 * @return
	 */
	Map<String, Object> queryAllTree();

	/**
	 * 根据pid, 查询子菜单列表
	 * @param pid
	 * @return
	 */
	Map<String, Object> queryShowTreeNodeByPid(Integer pid);

}
