package com.sc.service;

import java.util.List;
import java.util.Map;

import com.sc.model.request.DutySaveModel;
import com.sc.model.request.UpdateDutyModel;
import com.sc.model.response.DutyResult;

public interface IDutyService {

	/**
	 * 新增责任清单
	 * @param dutySaveModel
	 */
	void saveDuty(DutySaveModel dutySaveModel);

	/**
	 * 条件查询责任清单
	 * @param userId
	 * @param deptId
	 * @param posiId
	 * @return
	 */
	List<DutyResult> queryDutyByCondition(Integer userId, Integer deptId, Integer posiId);
	
	/**
	 * 根据部门id 或 岗位id, 查询各自的一二级职责
	 * @param qId, 部门或岗位id
	 * @param type: 部门：DEPT, 岗位：POSI
	 * @return
	 */
	List<Map<String, Object>> queryDutyByType(Integer qId, String type);
	
	/**
	 * 修改责任清单
	 * @param models
	 */
	void updateDuty(List<UpdateDutyModel> models);

	/**
	 * 删除责任清单
	 * @param id
	 */
	void deleteDutyById(Integer id);
	

}