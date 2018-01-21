package com.sc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.domain.Department;
import com.sc.domain.Plan;
import com.sc.domain.Position;
import com.sc.model.request.PlanModel;
import com.sc.model.request.QueryPlanModel;
import com.sc.service.IDepartmentService;
import com.sc.service.IPlanService;
import com.sc.service.IPositionService;
import com.sc.support.AuthUser;
import com.sc.support.UserContext;

/**
 * 计划完成情况
 */
@Controller
public class PlanController {

	private static final Logger logger = LoggerFactory.getLogger(DataRecordController.class);
	
	@Autowired
	private IPlanService planService;
	
	@Autowired
	private IPositionService positionService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@RequestMapping("/plan/planList")
	public String planList() {
		return "/plan/planList";
	}
	
	@RequestMapping("/plan/planManage")
	public String planManage() {
		return "/plan/planManage";
	}
	
	@RequestMapping("/plan/addPlan")
	public ModelAndView addPlan() {
		ModelAndView mv=new ModelAndView("/plan/addPlan");
		AuthUser authUser=UserContext.getAuthUser();
		Position posi= positionService.queryByCode(authUser.getRefPosi());
		Department dept=departmentService.queryByCode(authUser.getRefDept());
		mv.addObject("authUser", authUser);
		mv.addObject("posi", posi);
		mv.addObject("dept", dept);
		return mv;
	}
	
	
	/**
	 * 保存个人月度计划完成情况
	 */
	@RequestMapping(value = "/plan/save", method = { RequestMethod.POST })
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
	@RequestMapping(value = "/plan/query", method = { RequestMethod.POST })
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
	
	
	/**
	 * 修改计划
	 * 描述：上级领导的新增部分，下级员工不可修改和删除，若员工认为计划不妥，可线下向上级领导申请，由上级领导进行修改
	 * @param planModels
	 * @return
	 */
	@RequestMapping(value = "/plan/update", method = { RequestMethod.POST })
	@ResponseBody
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
	 * 删除计划情况
	 * 描述：上级领导的新增部分，下级员工不可修改和删除，若员工认为计划不妥，可线下向上级领导申请，由上级领导进行修改
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/plan/delete", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse deletePlan(@RequestParam(name="id", required=true)Integer id) {
		DataResponse dr = null;
		try {
			planService.deletePlanById(id);
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
	 * 新建计划
	 */
	@RequestMapping(value = "/plan/addPlanPost", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse addPlanPost(@RequestBody PlanModel planModel) {
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
	
	
}
