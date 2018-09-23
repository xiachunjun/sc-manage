package com.sc.service;

import java.util.List;

import com.sc.domain.DepartmentDomain;
import com.sc.model.request.DepartmentModel;
import com.sc.model.response.DeptPosiResult;

public interface IDepartmentService {

	/**
	 * 保存
	 * @param departmentModel
	 */
	void saveDepartment(DepartmentModel departmentModel);

	/**
	 * 修改
	 * @param departmentModel
	 */
	void updateDepartment(DepartmentModel departmentModel);

	/**
	 * 删除
	 */
	void deleteDepartmentById(Integer id);

	/**
	 * 根据状态查询
	 * 
	 * @return
	 */
	List<DepartmentDomain> queryByDataState(Integer dataState);

	/**
	 * 根据id查
	 * 
	 * @return
	 */
	DepartmentDomain queryById(Integer id);

	/**
	 * 查询各部门对应岗位列表
	 * @return
	 */
	List<DeptPosiResult> queryDeptPosiList();
	
}
