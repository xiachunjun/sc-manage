package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sc.common.mapper.MyMapper;
import com.sc.domain.DutyDomain;
import com.sc.model.response.DutyResult;

public interface DutyMapper extends MyMapper<DutyDomain>{

	@Select({
		"select ",
			"e.id as userId, e.user_name as userName, ",
			"b.id as deptId, b.dept_name as deptName, ",
			"c.id as posiId, c.posi_name as posiName ",
		"from sc_duty a ",
		"left join sc_departments b on b.id=a.ref_dept_id ",
		"left join sc_positions c on c.ref_dept_id=b.id ",
		"left join sc_user_posi_rel d on d.ref_posi_id=c.id ",
		"left join sc_users e on e.id=d.ref_user_id ",
		"where ${condition}"
	})
	List<DutyResult> selectDutyListByCondition(@Param("condition")String condition);
    
    
}