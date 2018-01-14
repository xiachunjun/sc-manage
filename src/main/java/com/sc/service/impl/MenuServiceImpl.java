package com.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dao.MenuMapper;
import com.sc.model.response.MenuResult;
import com.sc.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private MenuMapper menuMapper;

	
	@Override
	public MenuResult queryListByMenuLevel(String menuLevel) {
		MenuResult menuResult = menuMapper.queryListByMenuLevel(menuLevel);
		return menuResult;
	}

	
	@Override
	public MenuResult queryListByParentCode(String parentCode) {
		MenuResult menuResult = menuMapper.queryListByParentCode(parentCode);
		return menuResult;
	}
	
	
}
