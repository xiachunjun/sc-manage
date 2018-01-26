package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sc.common.mapper.MyMapper;
import com.sc.domain.DepartmentDomain;
import com.sc.model.response.DeptPosiResult;

public interface DepartmentMapper extends MyMapper<DepartmentDomain>{
    
	@Select({
		"select ",
			"a.id as deptId, a.dept_name as deptName, ",
			"b.id as posiId, b.posi_name as posiName ",
		"from sc_departments a ",
		"left join sc_positions b on a.id=b.ref_dept_id ",
		"where a.data_state=1"
	})
	List<DeptPosiResult> queryDeptPosiList();

	
	
}