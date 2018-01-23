package com.sc.service;

import java.util.List;

import com.sc.domain.PositionDomain;
import com.sc.model.request.PositionModel;

public interface IPositionService {

	/**
	 * 新增
	 * 
	 * @param positionModel
	 */
	void savePosition(PositionModel positionModel);

	/**
	 * 修改
	 * 
	 * @param positionModel
	 */
	void updatePosition(PositionModel positionModel);

	/**
	 * 删除
	 */
	void delatePosition(Integer id);

	/**
	 * 根据id查明细
	 */
	void queryPositionById(Integer id);

	/**
	 * 查询部门下全部岗位
	 * 
	 * @return
	 */
	List<PositionDomain> queryByDept(Integer deptId);

}
