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
import com.sc.service.IMenuService;


@RestController
public class MenuController {

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private IMenuService menuService;
	
	
	/**
	 * 查询父菜单列表
	 * @return
	 */
	@RequestMapping(value = "/menu/query/parentList", method = RequestMethod.POST)
	public DataResponse queryParentMenutList(){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = menuService.queryParentMenutList();
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
	
	
	/**
	 * 根据parentMenuCode, 查询子菜单列表
	 * @param parentMenuCode
	 * @return
	 */
	@RequestMapping(value = "/menu/query/List/byParentMenuCode", method = RequestMethod.POST)
	public DataResponse queryMenutListByParentMenuCode(
			@RequestParam(value="parentMenuCode", required=true)String parentMenuCode){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = menuService.queryMenutListByParentMenuCode(parentMenuCode);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("根据code, 查询子菜单列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	
}
