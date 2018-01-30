package com.sc.service;

import java.util.List;
import java.util.Map;

import com.sc.domain.DutyDomain;
import com.sc.model.request.DutySaveModel;
import com.sc.model.request.QueryDeptPosiDutyModel;
import com.sc.model.request.QueryDutyModel;
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
	 * @param queryDutyModel
	 * @return
	 */
	List<DutyResult> queryDutyByCondition(QueryDutyModel queryDutyModel);
	
	/**
	 * 根据部门id 或 岗位id, 查询各自的一二级职责
	 * @param queryDeptPosiDutyModel
	 * @return
	 */
	List<Map<String, Object>> queryDutyByType(QueryDeptPosiDutyModel queryDeptPosiDutyModel);
	
	
	/**
	 * 根据部门id 或 岗位id, 查询各自的一级职责或二级职责
	 * @param queryDeptPosiDutyModel
	 * @return
	 */
	List<DutyDomain> queryByTypeAndLevel(QueryDeptPosiDutyModel queryDeptPosiDutyModel);
	
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