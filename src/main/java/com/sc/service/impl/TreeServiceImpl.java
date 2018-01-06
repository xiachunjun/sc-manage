package com.sc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sc.dao.TreeMapper;
import com.sc.domain.Tree;
import com.sc.service.ITreeService;

@Service
public class TreeServiceImpl implements ITreeService {

	@Autowired
	private TreeMapper menuMapper;

	@Override
	public Map<String, Object> queryAllTree() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Tree> list = menuMapper.queryAllTree();
		if(!CollectionUtils.isEmpty(list)){
			dataMap.put("treeList", list);
		}
		return dataMap;
	}
	

	@Override
	public Map<String, Object> queryShowTreeNodeByPid(Integer pid){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Tree> list = menuMapper.queryShowTreeNodeByPid(pid);
		if(!CollectionUtils.isEmpty(list)){
			dataMap.put("treeList", list);
		}
		return dataMap;
	}
	
	
}
