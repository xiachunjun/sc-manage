package com.sc.service;

import java.util.List;
import java.util.Map;

public interface IDutyService {

	/**
	 * 根据部门code, 查询一二级职责
	 * @param deptCode
	 * @return
	 */
	List<Map<String, Object>> queryDutyByDeptCode(String deptCode);

	/**
	 * 根据岗位code, 查询一二级职责
	 * @param postCode
	 * @return
	 */
	List<Map<String, Object>> queryDutyByPostCode(String postCode);

	
}