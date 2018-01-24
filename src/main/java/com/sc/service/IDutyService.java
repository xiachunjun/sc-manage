package com.sc.service;

import java.util.List;

import com.sc.domain.DutyDomain;
import com.sc.model.request.DutySaveModel;
import com.sc.model.request.UpdateDutyModel;

public interface IDutyService {

	/**
	 * 新增责任清单
	 * @param dutySaveModel
	 */
	void saveDuty(DutySaveModel dutySaveModel);

	/**
	 * 条件查询责任清单
	 * @param deptId
	 * @param posiId
	 * @param dutyName
	 * @return
	 */
	List<DutyDomain> queryDutyByCondition(Integer deptId, Integer posiId, String dutyName);
	
	/**
	 * 根据部门id 或 岗位id, 查询各自的一二级职责
	 * @param qId, 部门或岗位id
	 * @param type: 部门：DEPT, 岗位：POSI
	 * @return
	 */
	List<DutyDomain> queryDutyByType(Integer qId, String type);
	
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