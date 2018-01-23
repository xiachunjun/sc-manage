package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.common.constant.ScException;
import com.sc.dao.PositionMapper;
import com.sc.domain.PositionDomain;
import com.sc.model.request.PositionModel;
import com.sc.service.IPositionService;

@Service
public class PositionServiceImpl implements IPositionService {

	@Autowired
	PositionMapper positionMapper;
	
	@Override
	public void savePosition(PositionModel positionModel) {
		PositionDomain positionDomain=new PositionDomain();
		BeanUtils.copyProperties(positionModel, positionDomain);
		int flag = positionMapper.insert(positionDomain);
		if (flag != 1) {
			throw new ScException("保存岗位出错");
		}
	}

	@Override
	public void updatePosition(PositionModel positionModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delatePosition(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryPositionById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PositionDomain> queryByDept(Integer deptId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
