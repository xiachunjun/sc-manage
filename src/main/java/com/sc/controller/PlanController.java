package com.sc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.domain.PlanDomain;
import com.sc.model.request.PlanDetailModel;
import com.sc.model.request.PlanModel;
import com.sc.model.request.QueryPlanModel;
import com.sc.service.IPlanService;
import com.sc.support.ValidatedGroup1;
import com.sc.support.ValidatedGroup2;
import com.sc.support.ValidatedGroup3;

/**
 * 计划完成情况
 */
@RestController
public class PlanController {

	private static final Logger logger = LoggerFactory.getLogger(DataRecordController.class);

	@Autowired
	private IPlanService planService;

	/**
	 * 新增（添加到sc_plans表）
	 */
	@RequestMapping(value = "/plan/addPlanPost", method = { RequestMethod.POST })
	public DataResponse addPlanPost(@RequestBody  @Validated(value={ValidatedGroup3.class}) PlanModel planModel) {
		DataResponse dr = null;
		try {
			planService.addPlan(planModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("新建计划异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 新建（添加到sc_plan_details表）
	 */
	@RequestMapping(value = "/plan/saveList", method = { RequestMethod.POST })
	public DataResponse savePlanList(@RequestBody List<PlanDetailModel> planDetailModels) {
		DataResponse dr = null;
		try {
			planService.savePlanDetailList(planDetailModels);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("新建个人月度计划完成情况异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 查询计划列表 tab传参: 1待办计划，2在办计划，3我的计划
	 */
	@RequestMapping(value = "/plan/query", method = { RequestMethod.POST })
	public DataResponse queryPlan(@RequestBody  @Validated(value={ValidatedGroup2.class}) QueryPlanModel planModel) {
		DataResponse dr = null;
		try {
			List<PlanDomain> list = planService.queryPlanByTab(planModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("planList", list);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询个人月度计划完成情况异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 修改计划 描述：上级领导的新增部分，下级员工不可修改和删除，若员工认为计划不妥，可线下向上级领导申请，由上级领导进行修改
	 * 
	 * @param planModels
	 * @return
	 */
	@RequestMapping(value = "/plan/update", method = { RequestMethod.POST })
	public DataResponse updatePlan(@RequestBody List<PlanModel> planModels) {
		DataResponse dr = null;
		try {
			planService.updatePlan(planModels);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("修改个人月度计划完成情况异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 删除计划情况 描述：上级领导的新增部分，下级员工不可修改和删除，若员工认为计划不妥，可线下向上级领导申请，由上级领导进行修改
	 */
	@RequestMapping(value = "/plan/delete", method = { RequestMethod.POST })
	public DataResponse deletePlan(@RequestBody  @Validated(value={ValidatedGroup1.class}) PlanModel planModel) {
		DataResponse dr = null;
		try {
			planService.deletePlanById(planModel.getId());
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("单条删除计划完成情况异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	
}
