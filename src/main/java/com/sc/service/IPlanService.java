package com.sc.service;

import java.util.List;

import com.sc.domain.PlanDomain;
import com.sc.model.request.PlanDetailModel;
import com.sc.model.request.PlanModel;
import com.sc.model.request.QueryPlanModel;

public interface IPlanService {

	/**
	 * 新增
	 * @param planModel
	 */
	void addPlan(PlanModel planModel);
	
	/**
	 * 新建
	 * @param planModels
	 */
	void savePlanDetailList(List<PlanDetailModel> planDetailModels);

	/**
	 * 根据条件，查询计划列表
	 * 
	 * @param planModel
	 * @return
	 */
	List<PlanDomain> queryPlanByTab(QueryPlanModel planModel);

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


}
