package com.sc.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.ScException;
import com.sc.dao.DepartmentMapper;
import com.sc.dao.PositionMapper;
import com.sc.domain.Position;
import com.sc.model.request.PositionModel;
import com.sc.service.IPositionService;

@Service
public class PositionServiceImpl implements IPositionService {

	@Autowired
	PositionMapper positionMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	
	@Override
	public List<Position> queryAllPosition() {
		List<Position> list=positionMapper.queryPositionList();
		return list;
	}

	@Override
	public List<Position> queryByDeptCode(String deptCode) {
		StringBuffer sb = new StringBuffer();
		sb.append(" p.data_state = 1 and");
		if(!StringUtils.isEmpty(deptCode)){
			sb.append(" p.ref_department_code="+deptCode);
		}else{
			return null;
		}
		List<Position> list =positionMapper.queryDutyByCondition(sb.substring(0, sb.length()-4));
		return list;
	}

	
	@Transactional
	@Override
	public void savePosition(PositionModel positionModel, String userLoginName) {
		Position record = setPositionProperty(positionModel, userLoginName);
		int flag = positionMapper.savePosition(record);
		if(flag != 1){
			throw new ScException("保存责任清单出错");
		}
	}


	@Override
	public Map<String, Object> queryPositionByCondition(PositionModel positionModel) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//组合关联条件查询
		String condition = packCondition(positionModel);
		List<Position> list = positionMapper.queryDutyByCondition(condition);
		dataMap.put("dataList", list);
		return dataMap;
	}


	@Transactional
	@Override
	public void updatePosition(PositionModel positionModel, String userLoginName) {
		Position record = new Position();
		BeanUtils.copyProperties(positionModel, record);
		record.setUpdateTime(new Date());
		record.setUpdateUser(StringUtils.isEmpty(userLoginName) ? "SYS" : userLoginName);
		int flag = positionMapper.updatePosition(record);
		if(flag != 1){
			throw new ScException("修改责任清单出错");
		}
	}

	
	/**********************以下为私有方法**********************/
	
	private Position setPositionProperty(PositionModel positionModel, String userLoginName) {
		Position record = new Position();
		BeanUtils.copyProperties(positionModel, record);
		record.setId(null);
		record.setDataState(1);
		record.setDataVersion(1);
		record.setCreateUser(StringUtils.isEmpty(userLoginName) ? "SYS" : userLoginName);
		record.setUpdateUser(record.getCreateUser());
		record.setCreateTime(new Date());
		record.setUpdateTime(record.getCreateTime());
		//设置userCode
		Integer maxCode = positionMapper.getMaxCode();
		if(null == maxCode){
			record.setPositionCode(CommonConstant.FIRST_CODE);
		}else{
			int length = String.valueOf(maxCode).length();
			switch(length){
				case 1 : record.setPositionCode("0000000"+(maxCode+1));  break;
				case 2 : record.setPositionCode("000000"+(maxCode+1));  break;
				case 3 : record.setPositionCode("00000"+(maxCode+1));  break;
				case 4 : record.setPositionCode("0000"+(maxCode+1));  break;
				case 5 : record.setPositionCode("000"+(maxCode+1));  break;
				case 6 : record.setPositionCode("00"+(maxCode+1));  break;
				case 7 : record.setPositionCode("0"+(maxCode+1));  break;
				case 8 : record.setPositionCode(""+(maxCode+1));  break;
				default: throw new ScException("超过最大长度");
			}
		}
		return record;
	}
	
	
	private String packCondition(PositionModel positionModel) {
		StringBuffer sb = new StringBuffer();
		sb.append(" p.data_state = 1 and");
		if(!StringUtils.isEmpty(positionModel.getDepartmentCode())){
			sb.append(" p.ref_department_code="+positionModel.getDepartmentCode()+" and");
		}
		if(!StringUtils.isEmpty(positionModel.getPositionName())){
			sb.append(" p.position_name="+positionModel.getPositionName()+" and");
		}
		if(!StringUtils.isEmpty(positionModel.getUserCode())){
			sb.append(" p.ref_user_code="+positionModel.getUserCode()+" and");
		}
		return sb.substring(0, sb.length()-4);
	}
	
	
}
