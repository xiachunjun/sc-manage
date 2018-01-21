package com.sc.service;

import java.util.List;

import com.sc.domain.Plan;
import com.sc.model.request.PlanModel;
import com.sc.model.request.QueryPlanModel;

public interface IPlanService {

	/**
	 * 保存个人月度计划完成情况
	 * 
	 * @param planModels
	 */
	void savePlan(List<PlanModel> planModels);

	/**
	 * 根据条件，查询计划列表
	 * 
	 * @param planModel
	 * @return
	 */
	List<Plan> queryPlanByTab(QueryPlanModel planModel);

	/**
	 * 修改计划情况
	 * 
	 * @param planModels
	 */
	void updatePlan(List<PlanModel> planModels);

	/**
	 * 单条删除计划情况
	 * 
	 * @param id
	 */
	void deletePlanById(Integer id);

	/**
	 * 单一添加
	 * 
	 * @param planModel
	 */
	void addPlan(PlanModel planModel);

}
