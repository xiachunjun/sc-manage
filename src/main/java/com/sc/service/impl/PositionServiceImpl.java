package com.sc.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dao.PositionMapper;
import com.sc.domain.Position;
import com.sc.service.IPositionService;

@Service
public class PositionServiceImpl implements IPositionService {

	@Autowired
	PositionMapper positionMapper;

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
		List<Position> list =positionMapper.queryDutyByCondition(sb.toString());
		return list;
	}

}
