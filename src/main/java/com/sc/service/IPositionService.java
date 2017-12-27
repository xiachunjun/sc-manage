package com.sc.service;

import java.util.List;
import java.util.Map;

import com.sc.domain.Position;
import com.sc.model.request.PositionModel;

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
	
	/**
	 * 新增责任清单
	 * @param positionModel
	 */
	void savePosition(PositionModel positionModel, String userLoginName);

	/**
	 * 条件查询责任清单
	 * @param positionModel
	 * @return
	 */
	Map<String, Object> queryPositionByCondition(PositionModel positionModel);

	/**
	 * 修改责任清单
	 * @param positionModel
	 */
	void updatePosition(PositionModel positionModel, String userLoginName);
	
	/**
	 * 编辑岗位责任人
	 * @return
	 */
	public void editPosition(PositionModel positionModel);
	
}
