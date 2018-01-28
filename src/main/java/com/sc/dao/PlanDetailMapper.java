package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sc.common.mapper.MyMapper;
import com.sc.domain.PlanDetailDomain;
import com.sc.model.response.PlanDetailResult;

public interface PlanDetailMapper extends MyMapper<PlanDetailDomain>{

	@Select({
		"select a.id, a.detail_content as detailContent, a.detail_type as detailType, ",
			"a.begin_time as beginTime, a.end_time as endTime, a.ref_plan_id as refPlanId,",
			"c.user_name as userName, c.user_login_name as userLoginName ",
		"from sc_plan_details a ",
		"left join sc_plans b on a.ref_plan_id=b.id ",
		"left join sc_users c on b.ref_user_id=c.id ",
		"where a.data_state=1 and a.ref_plan_id=#{planId,jdbcType=INTEGER}"	
	})
	List<PlanDetailResult> queryPlanDetailListByPlanId(@Param("planId")Integer id);

	@Select({
		"select ",
			"c.dept_name as deptName, d.user_name as userName, d.user_login_name as userLoginName,",
			"a.detail_type as detailType, a.detail_content as detailContent, a.update_user as updateUser,",
			"a.begin_time as beginTime, a.end_time as endTime, a.id, a.ref_plan_id as refPlanId,",
			"b.plan_main_user as planMainUser, b.plan_date as planDate,",
			"b.rate_of_progress as rateOfProgress, b.progress_info as progressInfo, e.posi_name as posiName ",
		"from sc_plan_details a ",
		"left join sc_plans b on a.ref_plan_id=b.id ",
		"left join sc_departments c on b.ref_dept_id=c.id ",
		"left join sc_users d on b.ref_user_id=d.id ",
		"left join sc_positions e on b.ref_posi_id=e.id ",
		"where ${condition}"
	})
	List<PlanDetailResult> queryPlanDetailList(@Param("condition")String condition);
    
	
}