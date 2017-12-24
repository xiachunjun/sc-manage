package com.sc.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.MyException;
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
		DataResponse dr = new DataResponse();
		try {
			dutyService.savePosition(positionModel);
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("新增责任清单出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	/**
	 * 条件查询责任清单
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/duty/query/list", method = {RequestMethod.POST})
	public DataResponse queryDutyByCondition(PositionModel positionModel){
		DataResponse dr = new DataResponse();
		try {
			Map<String, Object> dataMap = dutyService.queryDutyByCondition(positionModel);
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
			dr.setDataMap(dataMap);
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("查询责任清单出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
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
		DataResponse dr = new DataResponse();
		try {
			dutyService.updatePosition(positionModel);
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("修改责任清单出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	/**
	 * 查询部门列表
	 * @return
	 */
	@RequestMapping(value = "/department/query/list", method = {RequestMethod.POST})
	public DataResponse queryDepartmentList(){
		DataResponse dr = new DataResponse();
		try {
			Map<String, Object> dataMap = dutyService.queryDepartmentList();
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
			dr.setDataMap(dataMap);
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("查询部门列表异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	/**
	 * 查询岗位列表
	 * @return
	 */
	@RequestMapping(value = "/position/query/list", method = {RequestMethod.POST})
	public DataResponse queryPositionList(){
		DataResponse dr = new DataResponse();
		try {
			Map<String, Object> dataMap = dutyService.queryPositionList();
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
			dr.setDataMap(dataMap);
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("查询岗位列表异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	
	
}
