package com.sc.service;

import java.util.Map;

import com.sc.model.request.PositionModel;

public interface IDutyService {

	/**
	 * 新增责任清单
	 * @param positionModel
	 */
	void savePosition(PositionModel positionModel);

	/**
	 * 条件查询责任清单
	 * @param positionModel
	 * @return
	 */
	Map<String, Object> queryDutyByCondition(PositionModel positionModel);

	/**
	 * 修改责任清单
	 * @param positionModel
	 */
	void updatePosition(PositionModel positionModel);

	
}
