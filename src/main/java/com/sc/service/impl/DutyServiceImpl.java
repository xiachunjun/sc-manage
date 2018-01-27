package com.sc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.ScException;
import com.sc.dao.DutyMapper;
import com.sc.dao.UserPosiRelMapper;
import com.sc.domain.DutyDomain;
import com.sc.domain.UserPosiRelDomain;
import com.sc.model.request.DutySaveModel;
import com.sc.model.request.QueryDeptPosiDutyModel;
import com.sc.model.request.QueryDutyModel;
import com.sc.model.request.UpdateDutyModel;
import com.sc.model.response.DutyResult;
import com.sc.service.IDutyService;

@Service
public class DutyServiceImpl implements IDutyService {

	//private static final Logger logger = LoggerFactory.getLogger(DutyServiceImpl.class);

	@Autowired
	private DutyMapper dutyMapper;
	@Autowired
	private UserPosiRelMapper userPosiRelMapper;
	
	
	@Transactional
	@Override
	public void saveDuty(DutySaveModel dutySaveModel) {
		DutyDomain record = new DutyDomain();
		BeanUtils.copyProperties(dutySaveModel, record);
		//TODO 其他字段 和 处理一二级职责？？？
		int flag = dutyMapper.insertSelective(record);
		if (flag != 1) {
			throw new ScException("保存责任清单出错");
		}else{
			//TODO 修改
			UserPosiRelDomain record2 = new UserPosiRelDomain();
			record2.setRefUserId(dutySaveModel.getRefUserId());
			record2.setRefPosiId(dutySaveModel.getRefPosiId());
			userPosiRelMapper.insertSelective(record2);
		}
	}
	
	
	@Override
	public List<DutyResult> queryDutyByCondition(QueryDutyModel queryDutyModel) {
		StringBuffer sbf = new StringBuffer();
		sbf.append(" a.data_state=1 ");
		if(queryDutyModel.getDeptId() != null){
			sbf.append(" and a.ref_dept_id="+queryDutyModel.getDeptId());
		}
		if(queryDutyModel.getPosiId() != null){
			sbf.append(" and a.ref_posi_id="+queryDutyModel.getPosiId());
		}
		if(queryDutyModel.getUserId() != null){
			sbf.append(" and e.id="+queryDutyModel.getUserId());
		}
		List<DutyResult> list = dutyMapper.selectDutyListByCondition(sbf.toString());
		return list;
	}
	
	
	@Override
	public List<Map<String, Object>> queryDutyByType(QueryDeptPosiDutyModel queryDeptPosiDutyModel) {
		List<DutyDomain> list = null;
		DutyDomain record = new DutyDomain();
		if(StringUtils.equals(CommonConstant.DEPT, queryDeptPosiDutyModel.getType())){
			record.setRefDeptId(queryDeptPosiDutyModel.getqId());
			record.setDataState(1);
			record.setDutyType(queryDeptPosiDutyModel.getType());
			list = dutyMapper.select(record);
		}else if(StringUtils.equals(CommonConstant.POSI, queryDeptPosiDutyModel.getType())){
			record.setRefPosiId(queryDeptPosiDutyModel.getqId());
			record.setDataState(1);
			record.setDutyType(queryDeptPosiDutyModel.getType());
			list = dutyMapper.select(record);
		}
		//处理一二级职责
		List<Map<String, Object>> allList = new ArrayList<Map<String, Object>>();
		if(!CollectionUtils.isEmpty(list)){
			for (DutyDomain duty : list) {
				Map<String, Object> map = putLev2ToLev1(list, duty);
				if(map != null){
					allList.add(map);
				}
			}
		}
		return allList;
	}
	
	
	@Transactional
	@Override
	public void updateDuty(List<UpdateDutyModel> models) {
		for (UpdateDutyModel model : models) {
			DutyDomain record = new DutyDomain();
			record.setId(model.getId());
			record.setDutyIntroduce(model.getDutyIntroduce());
			//TODO 有时间再改成批量方式
			int flag = dutyMapper.updateByPrimaryKey(record);
			if(flag != 1){
				throw new ScException("修改责任清单出错");
			}
		}
	}
	
	
	@Transactional
	@Override
	public void deleteDutyById(Integer id) {
		DutyDomain record = new DutyDomain();
		record.setId(id);
		record.setDataState(1);
		int flag = dutyMapper.updateByPrimaryKey(record);
		if(flag != 1){
			throw new ScException("删除责任清单出错");
		}
	}
	


	/******************** 以下为私有方法 *********************/

	private Map<String, Object> putLev2ToLev1(List<DutyDomain> dutyList, DutyDomain duty) {
		if (StringUtils.equals(CommonConstant.ONE, duty.getDutyLevel())) {
			Map<String, Object> dataMap2 = new HashMap<String, Object>();
			List<String> twoList = new ArrayList<String>();
			dataMap2.put(CommonConstant.ONE_STR, duty.getDutyIntroduce());
			for (DutyDomain duty2 : dutyList) {
				if (duty2.getParentId() == duty.getId()) {
					if (StringUtils.equals(CommonConstant.TWO, duty2.getDutyLevel())) {
						twoList.add(duty2.getDutyIntroduce());
					}
				}
			}
			dataMap2.put(CommonConstant.TWO_STR, twoList);
			return dataMap2;
		}
		return null;
	}

	
}
