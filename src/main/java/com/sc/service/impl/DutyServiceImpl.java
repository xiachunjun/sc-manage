package com.sc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.MyException;
import com.sc.dao.DepartmentMapper;
import com.sc.dao.PositionMapper;
import com.sc.domain.Department;
import com.sc.domain.Position;
import com.sc.model.request.PositionModel;
import com.sc.service.IDutyService;

@Service
public class DutyServiceImpl implements IDutyService {

	@Autowired
	private PositionMapper positionMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	
	@Transactional
	@Override
	public void savePosition(PositionModel positionModel) {
		Position record = setPositionProperty(positionModel);
		//TODO 保存对应的code值
		int flag = positionMapper.savePosition(record);
		if(flag != 1){
			throw new MyException("保存责任清单出错");
		}
	}


	@Override
	public Map<String, Object> queryDutyByCondition(PositionModel positionModel) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//组合关联条件查询
		String condition = packCondition(positionModel);
		List<Position> list = positionMapper.queryDutyByCondition(condition);
		dataMap.put("dataList", list);
		return dataMap;
	}


	@Override
	public void updatePosition(PositionModel positionModel) {
		Position record = new Position();
		BeanUtils.copyProperties(positionModel, record);
		int flag = positionMapper.updatePosition(record);
		if(flag != 1){
			throw new MyException("修改责任清单出错");
		}
	}

	
	@Override
	public Map<String, Object> queryDepartmentList() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Department> list = departmentMapper.queryDepartmentList();
		dataMap.put("departmentList", list);
		return dataMap;
	}
	
	
	@Override
	public Map<String, Object> queryPositionList() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Position> list = positionMapper.queryPositionList();
		dataMap.put("positionList", list);
		return dataMap;
	}
	
	
	/**********************以下为私有方法**********************/
	
	private Position setPositionProperty(PositionModel positionModel) {
		Position record = new Position();
		BeanUtils.copyProperties(positionModel, record);
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
				default: throw new MyException("超过最大长度");
			}
		}
		return record;
	}
	
	
	private String packCondition(PositionModel positionModel) {
		StringBuffer sb = new StringBuffer();
		sb.append(" p.data_state = 1 and");
		if(!StringUtils.isEmpty(positionModel.getRefDepartmentCode())){
			sb.append(" p.ref_department_code="+positionModel.getRefDepartmentCode()+" and");
		}
		if(!StringUtils.isEmpty(positionModel.getPositionCode())){
			sb.append(" p.position_code="+positionModel.getPositionCode()+" and");
		}
		if(!StringUtils.isEmpty(positionModel.getRefUserCode())){
			sb.append(" p.ref_user_code="+positionModel.getRefUserCode()+" and");
		}
		return sb.substring(0, sb.length()-4);
	}
	
	
}
