package com.sc.service;

import java.util.List;

import com.sc.domain.PositionDomain;
import com.sc.model.request.PositionModel;

public interface IPositionService {

	/**
	 * 保存部门岗位
	 * @param positionModel
	 */
	void savePosition(PositionModel positionModel);
	
	/**
	 * 查询所有岗位
	 * @return
	 */
	List<PositionDomain> queryPosiList();
	
	/**
	 * 根据部门id, 查询岗位
	 * @param deptId
	 * @return
	 */
	List<PositionDomain> queryListByDeptId(Integer deptId);

	/**
	 * 修改岗位
	 * @param positionModel
	 */
	void updatePosition(PositionModel positionModel);
	
	/**
	 * 删除岗位
	 * @param id
	 */
	void deletePosition(Integer id);

	/**
	 * 根据岗位id，查询部门名称
	 * @param qId
	 * @return
	 */
	String queryDeptNameByPosiId(Integer qId);

	
}
