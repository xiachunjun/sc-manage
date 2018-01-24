package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.common.constant.ScException;
import com.sc.dao.DepartmentMapper;
import com.sc.domain.DepartmentDomain;
import com.sc.model.request.DepartmentModel;
import com.sc.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public List<DepartmentDomain> queryByDataState(Integer dataState) {
		DepartmentDomain record = new DepartmentDomain();
		record.setDataState(dataState);
		return departmentMapper.select(record);
	}

	
	@Override
	public DepartmentDomain queryById(Integer id) {
		DepartmentDomain dd = departmentMapper.selectByPrimaryKey(id);
		return dd;
	}

	
	@Transactional
	@Override
	public void saveDepartment(DepartmentModel departmentModel) {
		DepartmentDomain record = new DepartmentDomain();
		BeanUtils.copyProperties(departmentModel, record);
		//TODO 待修改
		int flag = departmentMapper.insertSelective(record);
		if (flag != 1) {
			throw new ScException("保存部门出错");
		}
	}

	
	@Transactional
	@Override
	public void updateDepartment(DepartmentModel departmentModel) {
		DepartmentDomain record = new DepartmentDomain();
		BeanUtils.copyProperties(departmentModel, record);
		//TODO 修改信息
		int flag = departmentMapper.updateByPrimaryKeySelective(record);
		if (flag != 1) {
			throw new ScException("修改部门出错");
		}
	}
	

	@Transactional
	@Override
	public void deleteDepartmentById(Integer id) {
		DepartmentDomain record = new DepartmentDomain();
		record.setId(id);
		record.setDataState(0);
		int flag = departmentMapper.updateByPrimaryKey(record);
		if (flag != 1) {
			throw new ScException("删除部门出错");
		}
	}
	

}
