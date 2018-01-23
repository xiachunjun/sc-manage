package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dao.DepartmentMapper;
import com.sc.domain.DepartmentDomain;
import com.sc.model.request.DepartmentModel;
import com.sc.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	DepartmentMapper departmentMapper;

	@Override
	public List<DepartmentDomain> queryByDataState(Integer dataState) {
		List<DepartmentDomain> list = departmentMapper.queryByDataState(dataState);
		return list;
	}

	@Override
	public DepartmentDomain queryById(Integer id) {
		DepartmentDomain dd = departmentMapper.selectByPrimaryKey(id);
		return dd;
	}

	@Override
	public void saveDepartment(DepartmentModel departmentModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDepartment(DepartmentModel departmentModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDepartment(DepartmentModel departmentModel) {
		// TODO Auto-generated method stub
		
	}

}
