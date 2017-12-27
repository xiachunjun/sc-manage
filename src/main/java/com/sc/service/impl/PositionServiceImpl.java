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
import com.sc.common.util.ListUtils;
import com.sc.dao.PositionMapper;
import com.sc.domain.Position;
import com.sc.model.request.PositionModel;
import com.sc.service.IPositionService;

@Service
public class PositionServiceImpl implements IPositionService {

	@Autowired
	PositionMapper positionMapper;

	@Override
	public List<Position> queryAllPosition() {
		List<Position> list = positionMapper.queryPositionList();
		return list;
	}

	@Override
	public List<Position> queryByDeptCode(String deptCode) {
		StringBuffer sb = new StringBuffer();
		sb.append(" p.data_state = 1 and");
		if (!StringUtils.isEmpty(deptCode)) {
			sb.append(" p.ref_department_code=" + deptCode);
		} else {
			return null;
		}
		List<Position> list = positionMapper.queryDutyByCondition(sb.toString());
		return list;
	}

	@Transactional
	@Override
	public void savePosition(PositionModel positionModel, String userLoginName) {
		Position record = setPositionProperty(positionModel, userLoginName);
		int flag = positionMapper.savePosition(record);
		if (flag != 1) {
			throw new ScException("保存责任清单出错");
		}
	}

	@Override
	public Map<String, Object> queryPositionByCondition(PositionModel positionModel) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 组合关联条件查询
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
		if (flag != 1) {
			throw new ScException("修改责任清单出错");
		}
	}

	@Override
	public void editPosition(PositionModel positionModel) {

		String userCode = positionModel.getUserCode();
		positionModel.setUserCode(null);
		String condition = packCondition(positionModel);
		List<Position> list = positionMapper.queryDutyByCondition(condition);
		if (null == list || list.size() != 1) {
			throw new ScException("编辑岗位职责出错！");
		}
		Position record = list.get(0);
		record.setRefUserCode(userCode);
		positionMapper.updatePosition(record);

	}

	/********************** 以下为私有方法 **********************/

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
		// 设置userCode
		Integer maxCode = positionMapper.getMaxCode();
		if (null == maxCode) {
			record.setPositionCode(CommonConstant.FIRST_CODE);
		} else {
			record.setPositionCode(ListUtils.addZero2Str(maxCode, 8));
		}
		return record;
	}

	private String packCondition(PositionModel positionModel) {
		StringBuffer sb = new StringBuffer();
		sb.append(" p.data_state = 1 and");
		if (!StringUtils.isEmpty(positionModel.getDepartmentCode())) {
			sb.append(" p.ref_department_code=" + positionModel.getDepartmentCode() + " and");
		}
		if (!StringUtils.isEmpty(positionModel.getPositionCode())) {
			sb.append(" p.position_code=" + positionModel.getPositionCode() + " and");
		}
		if (!StringUtils.isEmpty(positionModel.getUserCode())) {
			sb.append(" p.ref_user_code=" + positionModel.getUserCode() + " and");
		}
		return sb.substring(0, sb.length() - 4);
	}

}
