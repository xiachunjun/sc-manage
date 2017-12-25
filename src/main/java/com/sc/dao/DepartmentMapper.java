package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.Department;

public interface DepartmentMapper {

	@Select({
		"select id, ref_company_code, department_code, department_name, department_type, ",
			"department_level, parent_department_code ",
		"from sc_departments ",
		"where data_state = 1 order by department_type"
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="ref_company_code", property="refCompanyCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="department_code", property="departmentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="department_name", property="departmentName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="department_type", property="departmentType", jdbcType=JdbcType.VARCHAR),
	    @Result(column="department_level", property="departmentLevel", jdbcType=JdbcType.VARCHAR),
	    @Result(column="parent_department_code", property="parentDepartmentCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Department> queryDepartmentList();
	
	
}
