package com.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.sc.common.constant.ScException;
import com.sc.dao.PlanDetailMapper;
import com.sc.dao.PlanMapper;
import com.sc.dao.UserMapper;
import com.sc.domain.PlanDetailDomain;
import com.sc.domain.PlanDomain;
import com.sc.domain.UserDomain;
import com.sc.model.request.AddPlanModel;
import com.sc.model.request.PlanDetailModel;
import com.sc.model.request.QueryPlanModel;
import com.sc.model.response.PlanDetailResult;
import com.sc.model.response.UserInfoResult;
import com.sc.service.IPlanService;
import com.sc.support.AuthUser;
import com.sc.support.UserContext;

@Service
public class PlanServiceImpl implements IPlanService {

	//private static final Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);

	@Autowired
	private PlanMapper planMapper;
	@Autowired
	private PlanDetailMapper planDetailMapper;
	@Autowired
	private UserMapper userMapper;
	
	
	@Transactional
	@Override
	public void addPlan(AddPlanModel planModel) {
		List<PlanDetailModel> planDetailList = planModel.getPlanDetails();
		if(CollectionUtils.isEmpty(planDetailList)){
			throw new ScException("请至少填写一条计划");
		}
		AuthUser authUser = UserContext.getAuthUser();
		if(null == authUser || null == authUser.getId()){
			throw new ScException("对不起，请先登录");
		}
		UserInfoResult userInfo = userMapper.queryUserInfoByUserId(authUser.getId());
		if(null == userInfo){
			throw new ScException("对不起，该用户没有挂在任何部门");
		}
		UserDomain deptHeaderUser = userMapper.queryDeptHeaderByDeptId(userInfo.getDeptId());
		if(null == deptHeaderUser){
			throw new ScException("该部门没有主任");
		}
		PlanDomain planDomain = new PlanDomain();
		BeanUtils.copyProperties(planModel, planDomain);
		planDomain.setRefUserId(userInfo.getUserId());
		planDomain.setRefDeptId(userInfo.getDeptId());
		planDomain.setRefPosiId(userInfo.getPosiId());
		planDomain.setPlanMainUser(userInfo.getUserId());  //执行人
		planDomain.setCheckUser(deptHeaderUser.getId());   //审核人
		planDomain.setId(null);
		planDomain.setDataState(2);  // 审核状态：0-失效；1-初始；2-待领导审批；3-领导审核通过待执行人执行；4-领导审核不通过；5-执行人执行完成
		planDomain.setDataVersion(1);
		planDomain.setCreateUser(UserContext.getLoginName());
		planDomain.setUpdateUser(planDomain.getCreateUser());
		planDomain.setCreateTime(new Date());
		planDomain.setUpdateTime(planDomain.getCreateTime());
		//保存一条记录到sc_plans表
		int flag = planMapper.insertSelective(planDomain);
		if (flag == 1) {
			List<PlanDetailDomain> detailList = new ArrayList<PlanDetailDomain>();
			for (PlanDetailModel planDetailModel : planDetailList) {
				PlanDetailDomain planDetailDO = new PlanDetailDomain();
				planDetailDO.setRefPlanId(planDetailModel.getId());
				planDetailDO.setBeginTime(planDetailModel.getBeginTime());
				planDetailDO.setEndTime(planDetailModel.getEndTime());
				planDetailDO.setId(null);
				planDetailDO.setDataState(1);
				planDetailDO.setDataVersion(1);
				planDetailDO.setCreateUser(UserContext.getLoginName());
				planDetailDO.setUpdateUser(planDetailDO.getCreateUser());
				planDetailDO.setCreateTime(new Date());
				planDetailDO.setUpdateTime(planDetailDO.getCreateTime());
				detailList.add(planDetailDO);
			}
			//保存到sc_plan_details表
			int result = planDetailMapper.insertList(detailList);
			if(result != planDetailList.size()){
				throw new ScException("新增计划详情出错");
			}
		}else{
			throw new ScException("新增计划出错");
		}
	}
	
	
	@Override
	public List<PlanDetailResult> queryPlanDetailListByPlanId(Integer id) {
		return planDetailMapper.queryPlanDetailListByPlanId(id);
	}
	
	
	@Transactional
	@Override
	public void updatePlanDetail(List<PlanDetailModel> planDetailModelList) {
		if(CollectionUtils.isEmpty(planDetailModelList)){
			throw new ScException("请至少选择一条计划记录");
		}
		//sc_plans表的审核状态
		Integer planDataState = planDetailModelList.get(0).getPlanDataState();
		//sc_plans表的主键id
		Integer refPlanId = planDetailModelList.get(0).getRefPlanId();
		if(refPlanId == null || planDataState == null){
			throw new ScException("必要参数为空");
		}
		PlanDomain planDO = new PlanDomain();
		planDO.setId(refPlanId);
		planDO.setCheckTime(new Date());
		planDO.setDataState(planDataState);   // 审核状态：0-失效；1-初始；2-待领导审批；3-领导审核通过待执行人执行；4-领导审核不通过；5-执行人执行完成
		planDO.setUpdateTime(new Date());
		planDO.setUpdateUser(UserContext.getLoginName());
		int updateResult = planMapper.updateByPrimaryKeySelective(planDO);
		if(updateResult != 1){
			throw new ScException("审核计划任务，修改plan表记录出错");
		}
		for (PlanDetailModel planDetailModel : planDetailModelList) {
			//先查询plan_details表记录存不存在，存在即更新，不存在即新增
			PlanDetailDomain detailDO = null;
			if(null != planDetailModel.getId()){
				detailDO = planDetailMapper.selectByPrimaryKey(planDetailModel.getId());
			}
			//设置的内容
			PlanDetailDomain record = new PlanDetailDomain();
			record.setDetailType(planDetailModel.getDetailType());
			record.setDetailContent(planDetailModel.getDetailContent());
			record.setBeginTime(planDetailModel.getBeginTime());
			record.setEndTime(planDetailModel.getEndTime());
			record.setUpdateTime(new Date());
			if(null == detailDO){
				record.setId(null);
				record.setCreateTime(new Date());
				record.setCreateUser(UserContext.getLoginName());
				int insertDetailResult = planDetailMapper.insertSelective(record);
				if(insertDetailResult != 1){
					throw new ScException("审核计划任务，新增改plan_detail表记录出错");
				}
			}else{
				//有改动计划详情，则展示修订人（从updateUser读取）
				if(!StringUtils.equals(planDetailModel.getDetailContent(), detailDO.getDetailContent()) || 
					!DateUtils.isSameDay(planDetailModel.getBeginTime(), detailDO.getBeginTime()) ||
					!DateUtils.isSameDay(planDetailModel.getEndTime(), detailDO.getEndTime()) || 
					planDetailModel.getDetailType() != detailDO.getDetailType()){
					record.setUpdateUser(UserContext.getLoginName());
				}
				record.setId(planDetailModel.getId());
				int updateDetailResult = planDetailMapper.updateByPrimaryKeySelective(record);
				if(updateDetailResult != 1){
					throw new ScException("审核计划任务，修改plan_detail表记录出错");
				}
			}
		}
	}
	
	
	@Transactional
	@Override
	public void deletePlanDetailById(Integer id) {
		PlanDetailDomain record = new PlanDetailDomain();
		record.setId(id);
		record.setDataState(0);
		record.setUpdateTime(new Date());
		record.setUpdateUser(UserContext.getLoginName());
		int updateResult = planDetailMapper.updateByPrimaryKeySelective(record);
		if(updateResult != 1){
			throw new ScException("删除计划详情出错");
		}
	}
	
	
	@Override
	public List<PlanDetailResult> queryPlanList(QueryPlanModel queryPlanModel) {
		StringBuffer sbf = new StringBuffer();
		sbf.append(" a.data_state=1 ");
		if(StringUtils.isNoneBlank(queryPlanModel.getPlanDateStr())){
			sbf.append(" and date_format(b.plan_date,'%Y-%m')='"+queryPlanModel.getPlanDateStr()+"'");
		}
		if(null != queryPlanModel.getDetailType()){
			sbf.append(" and a.detail_type="+queryPlanModel.getDetailType());
		}
		if(null != queryPlanModel.getRefDeptId()){
			sbf.append(" and b.ref_dept_id="+queryPlanModel.getRefDeptId());
		}
		if(StringUtils.isNoneBlank(queryPlanModel.getRateOfProgress())){
			sbf.append(" and b.rate_of_progress='"+queryPlanModel.getRateOfProgress()+"'");
		}
		if(null != queryPlanModel.getRefUserId()){
			sbf.append(" and b.ref_user_id="+queryPlanModel.getRefUserId());
		}
		List<PlanDetailResult> detailList = planDetailMapper.queryPlanDetailList(sbf.toString());
		return detailList;
	}
	
	
	@Override
	public List<PlanDetailResult> queryPlanByTab(QueryPlanModel queryPlanModel) {
		AuthUser authUser = UserContext.getAuthUser();
		if(null == authUser || null == authUser.getId()){
			throw new ScException("对不起，请先登录");
		}
		if (null == queryPlanModel) {
			queryPlanModel = new QueryPlanModel();
			queryPlanModel.setTab(1); // 默认是查询待办计划
		}
		// 封装请求条件
		StringBuffer sbf = new StringBuffer();
		sbf.append(" a.data_state=1 ");
		if(null != queryPlanModel.getRefDeptId()){
			sbf.append(" and b.ref_dept_id="+queryPlanModel.getRefDeptId());
		}
		if(null != queryPlanModel.getRefUserId()){
			sbf.append(" and b.ref_user_id="+queryPlanModel.getRefUserId());
		}
		if(null != queryPlanModel.getDataState()){
			sbf.append(" and b.data_state="+queryPlanModel.getDataState());
		}
		if(StringUtils.isNoneBlank(queryPlanModel.getPlanDateStr())){
			sbf.append(" and date_format(b.plan_date,'%Y-%m')='"+queryPlanModel.getPlanDateStr()+"'");
		}
		// 判断查询的是哪个tab
		if (queryPlanModel.getTab() == 1) { // 1待办计划
			sbf.append(" and b.data_state >= 2");
		} else if (queryPlanModel.getTab() == 2) { // 2在办计划
			sbf.append(" and (b.data_state == 2 or b.data_state == 3 or b.data_state == 4)");
		} else if (queryPlanModel.getTab() == 3) { // 3我的计划
			sbf.append(" and b.ref_user_id="+authUser.getId());
		}
		return planDetailMapper.queryPlanDetailList(sbf.toString());
	}
	
	
}
