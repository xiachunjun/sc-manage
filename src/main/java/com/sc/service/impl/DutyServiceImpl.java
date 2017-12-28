package com.sc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sc.dao.DutyMapper;
import com.sc.domain.Duty;
import com.sc.service.IDutyService;

@Service
public class DutyServiceImpl implements IDutyService {

	//private static final Logger logger = LoggerFactory.getLogger(DutyServiceImpl.class);
	
	@Autowired
	private DutyMapper dutyMapper;

	
	@Override
	public List<Map<String, Object>> queryDutyByDeptCode(String deptCode) {
		List<Map<String, Object>> allList = new ArrayList<Map<String, Object>>();
		List<Duty> deptDutyList = dutyMapper.queryDutyByDeptCode(deptCode);
		if(!CollectionUtils.isEmpty(deptDutyList)){
			List<String> twoList = new ArrayList<String>();
			for (Duty duty : deptDutyList) {
				allList.add(putLev2ToLev1(deptDutyList, twoList, duty));
			}
		}
		return allList;
	}

	
	@Override
	public List<Map<String, Object>> queryDutyByPostCode(String postCode) {
		List<Map<String, Object>> allList = new ArrayList<Map<String, Object>>();
		List<Duty> posiDutyList = dutyMapper.queryDutyByPostCode(postCode);
		if(!CollectionUtils.isEmpty(posiDutyList)){
			List<String> twoList = new ArrayList<String>();
			for (Duty duty : posiDutyList) {
				allList.add(putLev2ToLev1(posiDutyList, twoList, duty));
			}
		}
		return allList;
	}
	
	
	/********************以下为私有方法*********************/
	
	private Map<String, Object> putLev2ToLev1(List<Duty> deptDutyList, List<String> twoList, Duty duty) {
		Map<String, Object> dataMap2 = new HashMap<String, Object>();
		if(StringUtils.equals("1", duty.getDutyLevel())){
			dataMap2.put("1", duty.getDutyIntroduce());
		}
		for (Duty duty2 : deptDutyList) {
			if(StringUtils.equals(duty2.getParentCode(), duty.getDutyCode())){
				if(StringUtils.equals("2", duty.getDutyLevel())){
					twoList.add(duty2.getDutyIntroduce());
				}
			}
		}
		dataMap2.put("2", twoList);
		return dataMap2;
	}
	
	
	
}
