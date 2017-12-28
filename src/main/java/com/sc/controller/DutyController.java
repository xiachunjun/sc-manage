package com.sc.controller;

import java.util.List;
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
import com.sc.service.IDutyService;

@RestController
public class DutyController {

	private static final Logger logger = LoggerFactory.getLogger(DutyController.class);
	
	@Autowired
	private IDutyService dutyService;
	
	/**
	 * 根据部门code, 查询一二级职责
	 */
	@RequestMapping(value = "/duty/queryByDeptCode", method = {RequestMethod.POST})
	public DataResponse queryDutyByDeptCode(@RequestParam(name="deptCode", required=true)String deptCode){
		DataResponse dr = null;
		try {
			List<Map<String, Object>> dataMap = dutyService.queryDutyByDeptCode(deptCode);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("deptDutyList", dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("根据部门code, 查询一二级职责异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 根据岗位code, 查询一二级职责
	 */
	@RequestMapping(value = "/duty/queryByPostCode", method = {RequestMethod.POST})
	public DataResponse queryDutyByPostCode(@RequestParam(name="posiCode", required=true)String posiCode){
		DataResponse dr = null;
		try {
			List<Map<String, Object>> dataMap = dutyService.queryDutyByPostCode(posiCode);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("posiDutyList", dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("根据岗位code, 查询一二级职责异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
}
