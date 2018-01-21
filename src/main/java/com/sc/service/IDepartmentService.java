package com.sc.service;

import java.util.List;

import com.sc.domain.Department;

public interface IDepartmentService {
	/**
	 * 所有
	 * 
	 * @return
	 */
	List<Department> queryAllDepartment();

	/**
	 * 根据code查
	 * 
	 * @param departmentCode
	 * @return
	 */
	Department queryByCode(String departmentCode);
}
