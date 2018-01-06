package com.sc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sc.dao.MenuMapper;
import com.sc.domain.Menu;
import com.sc.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public Map<String, Object> queryParentMenutList() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Menu> list = menuMapper.queryParentMenutList();
		if(!CollectionUtils.isEmpty(list)){
			dataMap.put("parentMenuList", list);
		}
		return dataMap;
	}
	

	@Override
	public Map<String, Object> queryMenutListByParentMenuCode(String parentMenuCode) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Menu> list = menuMapper.queryMenutListByParentMenuCode(parentMenuCode);
		if(!CollectionUtils.isEmpty(list)){
			dataMap.put("childMenuList", list);
		}
		return dataMap;
	}
	
	
}
