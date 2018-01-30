package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sc.common.mapper.MyMapper;
import com.sc.domain.PlanDomain;
import com.sc.model.response.PlanResult;

public interface PlanMapper extends MyMapper<PlanDomain>{

	@Select({
		"select ",
			"c.dept_name as deptName, d.user_name as userName, d.user_login_name as userLoginName,",
			"b.id, b.plan_main_user as planMainUser, b.plan_date as planDate,",
			"b.rate_of_progress as rateOfProgress, b.progress_info as progressInfo,",
			"e.posi_name as posiName ",
		"from sc_plans b ",
		"left join sc_departments c on b.ref_dept_id=c.id ",
		"left join sc_users d on b.ref_user_id=d.id ",
		"left join sc_positions e on b.ref_posi_id=e.id ",
		"where ${condition}"
	})
	List<PlanResult> queryPlanList(@Param("condition")String condition);
    
	
}