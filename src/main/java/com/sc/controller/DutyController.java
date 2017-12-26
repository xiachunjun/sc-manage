package com.sc.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ScException;
import com.sc.common.constant.ResponseEnum;
import com.sc.model.request.PositionModel;
import com.sc.service.IDutyService;

/**
 * 责任清单（还未完成，需求还未明确看完）
 */
@RestController
public class DutyController {

	private static final Logger logger = LoggerFactory.getLogger(DutyController.class);
	
	@Autowired
	private IDutyService dutyService;
	
	/**
	 * 新增责任清单
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/duty/save", method = {RequestMethod.POST})
	public DataResponse saveDuty(PositionModel positionModel){
		DataResponse dr = null;
		try {
			dutyService.savePosition(positionModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("新增责任清单出现异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 条件查询责任清单
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/duty/query/list", method = {RequestMethod.POST})
	public DataResponse queryDutyByCondition(@RequestBody PositionModel positionModel){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = dutyService.queryDutyByCondition(positionModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询责任清单出现异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 修改责任清单
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/duty/update", method = {RequestMethod.POST})
	public DataResponse updateDuty(PositionModel positionModel){
		DataResponse dr = null;
		try {
			dutyService.updatePosition(positionModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("修改责任清单出现异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 查询部门列表
	 * @return
	 */
	@RequestMapping(value = "/department/query/list", method = {RequestMethod.POST})
	public DataResponse queryDepartmentList(){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = dutyService.queryDepartmentList();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询部门列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 查询岗位列表
	 * @return
	 */
	@RequestMapping(value = "/position/query/list", method = {RequestMethod.POST})
	public DataResponse queryPositionList(){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = dutyService.queryPositionList();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询岗位列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	
	
}
