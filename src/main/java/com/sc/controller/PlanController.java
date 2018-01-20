package com.sc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.domain.Plan;
import com.sc.model.request.PlanModel;
import com.sc.model.request.QueryPlanModel;
import com.sc.service.IPlanService;

/**
 * 计划完成情况
 */
@Controller
public class PlanController {

	private static final Logger logger = LoggerFactory.getLogger(DataRecordController.class);
	
	@Autowired
	private IPlanService planService;
	
	/**
	 * 保存个人月度计划完成情况
	 */
	@RequestMapping(value = "/outer/plan/save", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse savePlan(@RequestBody List<PlanModel> planModels) {
		DataResponse dr = null;
		try {
			planService.savePlan(planModels);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("保存个人月度计划完成情况异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 查询计划列表
	 * tab传参: 1待办计划，2在办计划，3我的计划
	 */
	@RequestMapping(value = "/outer/plan/query", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse queryPlan(QueryPlanModel planModel) {
		DataResponse dr = null;
		try {
			List<Plan> list = planService.queryPlanByTab(planModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("planList", list);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("保存个人月度计划完成情况异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	
}
