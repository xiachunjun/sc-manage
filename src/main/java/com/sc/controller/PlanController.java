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
import com.sc.model.request.AddPlanModel;
import com.sc.model.request.PlanDetailModel;
import com.sc.model.request.QueryPlanModel;
import com.sc.model.response.PlanDetailResult;
import com.sc.model.response.PlanResult;
import com.sc.service.IPlanService;
import com.sc.support.ValidatedGroup1;
import com.sc.support.ValidatedGroup2;

/**
 * 计划完成情况
 */
@RestController
public class PlanController {

	private static final Logger logger = LoggerFactory.getLogger(DataRecordController.class);

	@Autowired
	private IPlanService planService;

	/**
	 * 新增计划
	 */
	@RequestMapping(value = "/plan/addPlan", method = { RequestMethod.POST })
	public DataResponse addPlan(@RequestBody AddPlanModel addPlanModel) {
		DataResponse dr = null;
		try {
			planService.addPlan(addPlanModel);
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
	 * 通过计划id，查询sc_plan_details表的记录
	 */
	@RequestMapping(value = "/plan/queryDetailListByPlanId", method = { RequestMethod.POST })
	public DataResponse queryDetailListByPlanId(@RequestBody  @Validated(value={ValidatedGroup1.class}) QueryPlanModel queryPlanModel) {
		DataResponse dr = null;
		try {
			List<PlanDetailResult> list = planService.queryPlanDetailListByPlanId(queryPlanModel.getId());
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("planDetailList", list);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("通过计划id，查询月度计划完成情况异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 个人计划列表（sc_plan_details）展示页面，领导可以给个人增加计划内容，或者修改个人的计划内容
	 */
	@RequestMapping(value = "/plan/updatePlanDetail", method = { RequestMethod.POST })
	public DataResponse updatePlanDetail(@RequestBody  @Validated(value={ValidatedGroup1.class, ValidatedGroup2.class}) List<PlanDetailModel> planDetailModelList) {
		DataResponse dr = null;
		try {
			planService.updatePlanDetail(planDetailModelList);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("计划异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	

	/**
	 * 删除计划情况 描述：上级领导的新增部分，下级员工不可修改和删除，若员工认为计划不妥，可线下向上级领导申请，由上级领导进行修改
	 */
	@RequestMapping(value = "/plan/deletePlanDetailById", method = { RequestMethod.POST })
	public DataResponse deletePlanDetailById(@RequestBody  @Validated(value={ValidatedGroup1.class}) PlanDetailModel planDetailModel) {
		DataResponse dr = null;
		try {
			planService.deletePlanDetailById(planDetailModel.getId());
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
	
	
	/**
	 * 查询完成情况计划列表
	 */
	@RequestMapping(value = "/plan/queryPlanList", method = { RequestMethod.POST })
	public DataResponse queryPlanList(@RequestBody QueryPlanModel queryPlanModel) {
		DataResponse dr = null;
		try {
			List<PlanDetailResult> list = planService.queryPlanList(queryPlanModel);
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
	 * 查询计划列表 tab传参: 1待办计划，2在办计划，3我的计划
	 */
	@RequestMapping(value = "/plan/queryByTab", method = { RequestMethod.POST })
	public DataResponse queryByTab(@RequestBody  @Validated(value={ValidatedGroup2.class}) QueryPlanModel planModel) {
		DataResponse dr = null;
		try {
			List<PlanResult> list = planService.queryPlanByTab(planModel);
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
	

	
}
