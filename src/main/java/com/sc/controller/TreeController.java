package com.sc.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.service.ITreeService;

/**
 * 菜单栏相关功能
 *
 */
@RestController
public class TreeController {

	private static final Logger logger = LoggerFactory.getLogger(TreeController.class);
	
	@Autowired
	private ITreeService treeService;
	
	
	/**
	 * 点击事件加载树节点
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/tree/show/node/byPid", method = RequestMethod.POST)
	public DataResponse queryShowTreeNodeByPid(@RequestParam(value="pid", required=true)Integer pid){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = treeService.queryShowTreeNodeByPid(pid);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("根据pid, 查询子菜单列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 一次性加载树节点， 不采取
	 * @return
	 */
	@RequestMapping(value = "/tree/query/all", method = RequestMethod.POST)
	public DataResponse queryAllTree(){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = treeService.queryAllTree();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询菜单列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	
	
	
	
}
