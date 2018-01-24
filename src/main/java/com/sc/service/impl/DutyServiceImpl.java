package com.sc.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.common.constant.ScException;
import com.sc.dao.DutyMapper;
import com.sc.dao.UserPosiRelMapper;
import com.sc.domain.DutyDomain;
import com.sc.domain.UserPosiRelDomain;
import com.sc.model.request.DutySaveModel;
import com.sc.model.request.UpdateDutyModel;
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
	public List<DutyDomain> queryDutyByCondition(Integer deptId, Integer posiId, String dutyName) {
		DutyDomain record = new DutyDomain();
		record.setDataState(1);
		if(deptId != null){
			record.setRefDeptId(deptId);
		}
		if(posiId != null){
			record.setRefPosiId(posiId);
		}
		if(StringUtils.isNoneBlank(dutyName)){
			//TODO 按责任人进行查询
		}
		List<DutyDomain> list = dutyMapper.select(record);
		return list;
	}
	
	
	@Override
	public List<DutyDomain> queryDutyByType(Integer qId, String type) {
		List<DutyDomain> list = null;
		DutyDomain record = new DutyDomain();
		if(StringUtils.equals("DEPT", type)){
			record.setRefDeptId(qId);
			record.setDataState(1);
			list = dutyMapper.select(record);
		}else if(StringUtils.equals("POSI", type)){
			record.setRefPosiId(qId);
			record.setDataState(1);
			list = dutyMapper.select(record);
		}
		//TODO 需不需要在后端处理一二级职责的展示
		return list;
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
	
	
//	@Override
//	public List<Map<String, Object>> queryByDeptOrPosi(Integer refId, String type) {
//		logger.info("DutyServiceImpl.queryByDeptOrPosi==" + refId + "-" + type);
//		List<Map<String, Object>> allList = new ArrayList<Map<String, Object>>();
//		String condition = "";
//		if (CommonConstant.DEPT.equals(type)) {
//			condition = " and ref_dept_id=" + refId;
//		} else if (CommonConstant.POSI.equals(type)) {
//			condition = " and ref_posi_id=" + refId;
//		}
//		List<DutyDomain> dutyList = dutyMapper.queryByDeptOrPosi(condition);
//		if (!CollectionUtils.isEmpty(dutyList)) {
//			for (DutyDomain duty : dutyList) {
//				Map<String, Object> map = putLev2ToLev1(dutyList, duty);
//				if (map != null) {
//					allList.add(map);
//				}
//			}
//		}
//		return allList;
//	}


	/******************** 以下为私有方法 *********************/

//	private Map<String, Object> putLev2ToLev1(List<DutyDomain> dutyList, DutyDomain duty) {
//		if (StringUtils.equals(CommonConstant.ONE, duty.getDutyLevel())) {
//			Map<String, Object> dataMap2 = new HashMap<String, Object>();
//			List<String> twoList = new ArrayList<String>();
//			dataMap2.put(CommonConstant.ONE_STR, duty.getDutyIntroduce());
//			for (DutyDomain duty2 : dutyList) {
//				if (duty2.getParentId() == duty.getId()) {
//					if (StringUtils.equals(CommonConstant.TWO, duty2.getDutyLevel())) {
//						twoList.add(duty2.getDutyIntroduce());
//					}
//				}
//			}
//			dataMap2.put(CommonConstant.TWO_STR, twoList);
//			return dataMap2;
//		}
//		return null;
//	}

	
}
