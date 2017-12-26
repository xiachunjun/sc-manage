package com.sc.service;

import java.util.List;

import com.sc.domain.Position;

public interface IPositionService {
	/**
	 * 查全部
	 * 
	 * @return
	 */
	List<Position> queryAllPosition();

	/**
	 * 根据部门代码查
	 * 
	 * @return
	 */
	List<Position> queryByDeptCode(String deptCode);
}
