package com.sc.service;

import java.util.List;

import com.sc.model.request.AddPlanModel;
import com.sc.model.request.PlanDetailModel;
import com.sc.model.request.QueryPlanModel;
import com.sc.model.response.PlanDetailResult;
import com.sc.model.response.PlanResult;

public interface IPlanService {

	/**
	 * 新增
	 * @param planModel
	 */
	void addPlan(AddPlanModel planModel);

	/**
	 * 通过计划id，查询sc_plan_details表的记录
	 * @param id
	 * @return
	 */
	List<PlanDetailResult> queryPlanDetailListByPlanId(Integer id);
	
	
	/**
	 * 个人计划列表（sc_plan_details）展示页面，领导可以给个人增加计划内容，或者修改个人的计划内容
	 * @param planDetailModelList
	 */
	void updatePlanDetail(List<PlanDetailModel> planDetailModelList);
	
	/**
	 * 删除detail_plan计划详情
	 * @param id
	 */
	void deletePlanDetailById(Integer id);

	/**
	 * 查询完成情况计划列表
	 * @param queryPlanModel
	 * @return
	 */
	List<PlanDetailResult> queryPlanList(QueryPlanModel queryPlanModel);
	
	/**
	 * 根据条件，查询计划列表
	 * 
	 * @param planModel
	 * @return
	 */
	List<PlanResult> queryPlanByTab(QueryPlanModel planModel);

	
	
}
