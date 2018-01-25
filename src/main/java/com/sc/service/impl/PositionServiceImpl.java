package com.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.common.constant.ScException;
import com.sc.dao.PositionMapper;
import com.sc.domain.PositionDomain;
import com.sc.model.request.PositionModel;
import com.sc.service.IPositionService;
import com.sc.support.UserContext;

@Service
public class PositionServiceImpl implements IPositionService {

	@Autowired
	private PositionMapper positionMapper;
	
	
	@Transactional
	@Override
	public void savePosition(PositionModel positionModel) {
		PositionDomain positionDomain=new PositionDomain();
		BeanUtils.copyProperties(positionModel, positionDomain);
		positionDomain.setId(null);
		positionDomain.setDataState(1);
		positionDomain.setDataVersion(1);
		positionDomain.setCreateUser(UserContext.getLoginName());
		positionDomain.setUpdateUser(positionDomain.getCreateUser());
		positionDomain.setCreateTime(new Date());
		positionDomain.setUpdateTime(positionDomain.getCreateTime());
		int flag = positionMapper.insertSelective(positionDomain);
		if (flag != 1) {
			throw new ScException("保存岗位出错");
		}
	}


	@Override
	public List<PositionDomain> queryListByDeptId(Integer deptId) {
		PositionDomain record = new PositionDomain();
		record.setRefDeptId(deptId);
		record.setDataState(1);
		return positionMapper.select(record);
	}
	

	@Transactional
	@Override
	public void updatePosition(PositionModel positionModel) {
		PositionDomain record = new PositionDomain();
		BeanUtils.copyProperties(positionModel, record);
		record.setUpdateUser(UserContext.getLoginName());
		record.setUpdateTime(new Date());
		int flag = positionMapper.updateByPrimaryKeySelective(record);
		if (flag != 1) {
			throw new ScException("修改岗位出错");
		}
	}
	
	
	@Transactional
	@Override
	public void deletePosition(Integer id) {
		PositionDomain record = new PositionDomain();
		record.setId(id);
		record.setDataState(0);
		record.setUpdateUser(UserContext.getLoginName());
		record.setUpdateTime(new Date());
		int flag = positionMapper.updateByPrimaryKey(record);
		if (flag != 1) {
			throw new ScException("删除岗位出错");
		}
	}
	
	
}
