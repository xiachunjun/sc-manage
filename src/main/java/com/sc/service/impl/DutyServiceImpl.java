package com.sc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sc.common.constant.CommonConstant;
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
			for (Duty duty : deptDutyList) {
				Map<String, Object> map = putLev2ToLev1(deptDutyList, duty);
				if(map != null){
					allList.add(map);
				}
			}
		}
		return allList;
	}

	
	@Override
	public List<Map<String, Object>> queryDutyByPosiCode(String posiCode) {
		List<Map<String, Object>> allList = new ArrayList<Map<String, Object>>();
		List<Duty> posiDutyList = dutyMapper.queryDutyByPostCode(posiCode);
		if(!CollectionUtils.isEmpty(posiDutyList)){
			for (Duty duty : posiDutyList) {
				Map<String, Object> map = putLev2ToLev1(posiDutyList, duty);
				if(map != null){
					allList.add(map);
				}
			}
		}
		return allList;
	}
	
	
	/********************以下为私有方法*********************/
	
	private Map<String, Object> putLev2ToLev1(List<Duty> deptDutyList, Duty duty) {
		if(StringUtils.equals(CommonConstant.ONE, duty.getDutyLevel())){
			Map<String, Object> dataMap2 = new HashMap<String, Object>();
			List<String> twoList = new ArrayList<String>();
			dataMap2.put(CommonConstant.ONE_STR, duty.getDutyIntroduce());
			for (Duty duty2 : deptDutyList) {
				if(StringUtils.equals(duty2.getParentCode(), duty.getDutyCode())){
					if(StringUtils.equals(CommonConstant.TWO, duty2.getDutyLevel())){
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
