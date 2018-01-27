package com.sc.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sc.common.mapper.MyMapper;
import com.sc.domain.PositionDomain;

public interface PositionMapper extends MyMapper<PositionDomain>{

	@Select({
		"select b.dept_name as deptName", 
		"from sc_positions a ",
		"left join sc_departments b on b.id=a.ref_dept_id ",
		"where a.id=#{qId,jdbcType=INTEGER}"
	})
	String queryDeptNameByPosiId(@Param("qId")Integer qId);
   
	
}