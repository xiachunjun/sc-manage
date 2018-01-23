package com.sc.service;

import java.util.List;
import java.util.Map;

import com.sc.domain.DutyDomain;

public interface IDutyService {

	void saveDuty(DutyDomain dutyDomain);

	void updateDuty(DutyDomain dutyDomain);

	void deleteDuty(Integer id);

	void queryById(Integer id);

	/**
	 * 根据部门, 查询一二级职责
	 * 
	 * @param deptId
	 * @return
	 */
	List<Map<String, Object>> queryByDeptOrPosi(Integer refId,String type);

}