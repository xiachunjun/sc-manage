package com.sc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sc.common.constant.CommonConstant;
import com.sc.dao.DutyMapper;
import com.sc.domain.DutyDomain;
import com.sc.service.IDutyService;

@Service
public class DutyServiceImpl implements IDutyService {

	private static final Logger logger = LoggerFactory.getLogger(DutyServiceImpl.class);

	@Autowired
	private DutyMapper dutyMapper;

	@Override
	public List<Map<String, Object>> queryByDeptOrPosi(Integer refId, String type) {
		logger.info("DutyServiceImpl.queryByDeptOrPosi==" + refId + "-" + type);
		List<Map<String, Object>> allList = new ArrayList<Map<String, Object>>();
		String condition = "";
		if (CommonConstant.DEPT.equals(type)) {
			condition = " and ref_dept_id=" + refId;
		} else if (CommonConstant.POSI.equals(type)) {
			condition = " and ref_posi_id=" + refId;
		}
		List<DutyDomain> dutyList = dutyMapper.queryByDeptOrPosi(condition);
		if (!CollectionUtils.isEmpty(dutyList)) {
			for (DutyDomain duty : dutyList) {
				Map<String, Object> map = putLev2ToLev1(dutyList, duty);
				if (map != null) {
					allList.add(map);
				}
			}
		}
		return allList;
	}

	

	@Override
	public void saveDuty(DutyDomain dutyDomain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDuty(DutyDomain dutyDomain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDuty(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void queryById(Integer id) {
		// TODO Auto-generated method stub

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
