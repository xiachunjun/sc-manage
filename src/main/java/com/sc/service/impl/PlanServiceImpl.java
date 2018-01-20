package com.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.sc.common.constant.ScException;
import com.sc.dao.PlanMapper;
import com.sc.domain.Plan;
import com.sc.model.request.PlanModel;
import com.sc.model.request.QueryPlanModel;
import com.sc.service.IPlanService;
import com.sc.support.AuthUser;
import com.sc.support.UserContext;

@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	private PlanMapper planMapper;
	
	@Transactional
	@Override
	public void savePlan(List<PlanModel> planModels) {
		if(CollectionUtils.isEmpty(planModels)){
			throw new ScException("请填写个人计划完成情况");
		}
		List<Plan> list = new ArrayList<Plan>();
		for (PlanModel planModel : planModels) {
			Plan record = new Plan();
			BeanUtils.copyProperties(planModel, record);
			//TODO 具体业务待修改
			record.setId(null);
			record.setDataState(1);
			record.setDataVersion(1);
			record.setCreateUser("SYS"); //TODO 
			record.setUpdateUser(record.getCreateUser());
			record.setCreateTime(new Date());
			record.setUpdateTime(record.getCreateTime());
			list.add(record);
		}
		int flag = planMapper.batchInsert(list);
		if(flag <= 0){
			throw new ScException("填写个人计划完成情况出错");
		}
	}
	
	
	@Override
	public List<Plan> queryPlanByTab(QueryPlanModel planModel) {
		if(null == planModel){
			planModel = new QueryPlanModel();
			planModel.setTab(1);   //默认是查询待办计划
		}
		//查看当前登录人的身份，不同身份拥有不同的查询内容
		AuthUser authUser = UserContext.getAuthUser();
		
		//封装请求条件
		StringBuffer sb = new StringBuffer();
		sb.append(" p.data_state = 1 and");
		if (StringUtils.isNoneBlank(planModel.getRefDept())) {
			sb.append(" p.ref_dept='" + planModel.getRefDept()+"'");
		}else{
			throw new ScException("请选择部门");
		}
		if (StringUtils.isNoneBlank(planModel.getPlanMainPerson())) {
			sb.append(" p.plan_main_person='" + planModel.getPlanMainPerson()+"'");
		}
		if (StringUtils.isNoneBlank(planModel.getRateOfProgress())) {
			sb.append(" p.rate_of_progress='" + planModel.getRateOfProgress()+"'");
		}
		if (planModel.getPlanDate() != null) {
			sb.append(" date_format(p.ref_dept, '%Y%m')="+"date_format("+planModel.getRefDept()+", '%Y%m')");
		}
		//判断查询的是哪个tab
		if(planModel.getTab() == 1){ //1待办计划
			sb.append(" p.progress_info = '待办'");
			//TODO 查询该登录用户是否是该部门领导
			sb.append(" p.ref_user='" + authUser.getUserLoginName()+"'");
			
		}else if(planModel.getTab() == 2){ //2在办计划
			sb.append(" p.progress_info != '结束'");
			//TODO 查询该登录用户是否是该部门领导
			sb.append(" p.ref_user='" + authUser.getUserLoginName()+"'");
			
		}else if(planModel.getTab() == 3){ //3我的计划
			sb.append(" p.ref_user='" + authUser.getUserLoginName()+"'");
		}
		return planMapper.selectListByCondition(sb.toString());
	}
	
	
	
}
