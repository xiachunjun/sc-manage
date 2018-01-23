package com.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.sc.common.constant.ScException;
import com.sc.dao.PlanMapper;
import com.sc.domain.DepartmentDomain;
import com.sc.domain.PlanDomain;
import com.sc.domain.PositionDomain;
import com.sc.model.request.PlanModel;
import com.sc.model.request.QueryPlanModel;
import com.sc.service.IDepartmentService;
import com.sc.service.IPlanService;
import com.sc.service.IPositionService;
import com.sc.support.AuthUser;
import com.sc.support.UserContext;

@Service
public class PlanServiceImpl implements IPlanService {

	private static final Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);

	@Autowired
	private PlanMapper planMapper;
	
	@Autowired
	private IPositionService positionService;
	
	@Autowired
	private IDepartmentService departmentService;

	@Transactional
	@Override
	public void savePlan(List<PlanModel> planModels) {
		if (CollectionUtils.isEmpty(planModels)) {
			throw new ScException("请填写个人计划完成情况");
		}
		List<PlanDomain> list = new ArrayList<PlanDomain>();
		for (PlanModel planModel : planModels) {
			PlanDomain record = new PlanDomain();
			BeanUtils.copyProperties(planModel, record);
			// TODO 具体业务待修改
			record.setId(null);
			record.setDataState(1);
			record.setDataVersion(1);
			record.setCreateUser("SYS"); // TODO
			record.setUpdateUser(record.getCreateUser());
			record.setCreateTime(new Date());
			record.setUpdateTime(record.getCreateTime());
			list.add(record);
		}
//		int flag = planMapper.batchInsert(list);
//		if (flag <= 0) {
//			throw new ScException("填写个人计划完成情况出错");
//		}
	}

	@Override
	public List<PlanDomain> queryPlanByTab(QueryPlanModel planModel) {
//		if (null == planModel) {
//			planModel = new QueryPlanModel();
//			planModel.setTab(1); // 默认是查询待办计划
//		}
//		// 查看当前登录人的身份，不同身份拥有不同的查询内容
//		AuthUser authUser = UserContext.getAuthUser();
//
//		// 封装请求条件
//		StringBuffer sb = new StringBuffer();
//		sb.append(" p.data_state = 1 and");
//		if (StringUtils.isNoneBlank(planModel.getRefDept())) {
//			sb.append(" p.ref_dept='" + planModel.getRefDept() + "'");
//		} else {
//			throw new ScException("请选择部门");
//		}
//		if (StringUtils.isNoneBlank(planModel.getPlanMainPerson())) {
//			sb.append(" p.plan_main_person='" + planModel.getPlanMainPerson() + "'");
//		}
//		if (StringUtils.isNoneBlank(planModel.getRateOfProgress())) {
//			sb.append(" p.rate_of_progress='" + planModel.getRateOfProgress() + "'");
//		}
//		if (planModel.getPlanDate() != null) {
//			sb.append(" date_format(p.ref_dept, '%Y%m')=" + "date_format(" + planModel.getRefDept() + ", '%Y%m')");
//		}
//		// 判断查询的是哪个tab
//		if (planModel.getTab() == 1) { // 1待办计划
//			sb.append(" p.progress_info = '待办'");
//			// TODO 查询该登录用户是否是该部门领导
//			sb.append(" p.ref_user='" + authUser.getUserLoginName() + "'");
//
//		} else if (planModel.getTab() == 2) { // 2在办计划
//			sb.append(" p.progress_info != '结束'");
//			// TODO 查询该登录用户是否是该部门领导
//			sb.append(" p.ref_user='" + authUser.getUserLoginName() + "'");
//
//		} else if (planModel.getTab() == 3) { // 3我的计划
//			sb.append(" p.ref_user='" + authUser.getUserLoginName() + "'");
//		}
//		return planMapper.selectListByCondition(sb.toString());
		return null;
	}

	@Transactional
	@Override
	public void updatePlan(List<PlanModel> planModels) {
		if (CollectionUtils.isEmpty(planModels)) {
			throw new ScException("请输入要修改的记录");
		}
		AuthUser authUser = UserContext.getAuthUser();
		// TODO 先查询修改的记录是否存在领导添加的
		List<Integer> ids = new ArrayList<Integer>();
		for (PlanModel planModel : planModels) {
			ids.add(planModel.getId());
		}
//		List<PlanDomain> pList = planMapper.selectListByIdList(ids);
//		for (PlanDomain plan : pList) {
//			// TODO
//		}

		for (PlanModel planModel : planModels) {
			PlanDomain record = new PlanDomain();
			record.setId(planModel.getId());
			record.setPlanType(planModel.getPlanType());
			record.setUpdateUser(authUser.getUserLoginName());
//			int result = planMapper.updatePlanById(record);
//			if (result != 1) {
//				throw new ScException("修改计划情况出错");
//			}
		}
	}

	@Transactional
	@Override
	public void deletePlanById(Integer id) {
		AuthUser authUser = UserContext.getAuthUser();
//		PlanDomain planDomain = planMapper.selectById(id);
//		if (planDomain == null) {
//			throw new ScException("对不起，找不到该记录!");
//		}
		// TODO 先查询该条记录是否是领导添加的, 如果是领导添加的，则提示没有改权限进行删除； 如果是领导自己或者等级更高？

//		int result = planMapper.deleteById(id);
//		if (result != 1) {
//			throw new ScException("删除计划情况出错");
//		}
	}

	@Override
	public void addPlan(PlanModel planModel) {
		if (planModel == null) {
			throw new ScException("planModel为空!");
		}
		try {
			PlanDomain plan = new PlanDomain();
			BeanUtils.copyProperties(planModel, plan);
//			AuthUser authUser=UserContext.getAuthUser();
//			plan.setRefUser(authUser.getUserCode());
//			plan.setCreateUser(authUser.getUserCode());
//			plan.setUpdateUser(authUser.getUserCode());
//			planMapper.savePlan(plan);
		} catch (Exception e) {
			logger.error("PlanServiceImpl.addPlan===", e);
			throw new ScException("planModel为空!");
		}
	}

}
