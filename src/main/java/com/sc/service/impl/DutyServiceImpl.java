package com.sc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.common.constant.MyException;
import com.sc.dao.PositionMapper;
import com.sc.domain.Position;
import com.sc.model.request.PositionModel;
import com.sc.service.IDutyService;

@Service
public class DutyServiceImpl implements IDutyService {

	@Autowired
	private PositionMapper positionMapper;
	
	
	@Override
	public void savePosition(PositionModel positionModel) {
		Position record = new Position();
		BeanUtils.copyProperties(positionModel, record);
		//TODO 
		int flag = positionMapper.savePosition(record);
		if(flag != 1){
			throw new MyException("保存责任清单出错");
		}
	}
	

	@Override
	public Map<String, Object> queryPosition(PositionModel positionModel) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//TODO 关联条件查询
		List<Position> list = positionMapper.queryPosition(positionModel);
		dataMap.put("dutyList", list);
		return dataMap;
	}

	
	@Override
	public void updatePosition(PositionModel positionModel) {
		Position record = new Position();
		BeanUtils.copyProperties(positionModel, record);
		//TODO 
		int flag = positionMapper.updatePosition(record);
		if(flag != 1){
			throw new MyException("修改责任清单出错");
		}
	}

	
}