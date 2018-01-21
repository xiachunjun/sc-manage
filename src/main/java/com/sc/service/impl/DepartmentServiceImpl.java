package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dao.DepartmentMapper;
import com.sc.domain.Department;
import com.sc.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	DepartmentMapper departmentMapper;

	@Override
	public List<Department> queryAllDepartment() {
		List<Department> list = departmentMapper.queryDepartmentList();
		return list;
	}

	@Override
	public Department queryByCode(String departmentCode) {
		return departmentMapper.queryByCode(departmentCode);
	}

}
