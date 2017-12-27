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
import com.sc.model.request.DayMessageModel;
import com.sc.service.IDayMessageService;

/**
 * 每日信息
 * 
 */
@RestController
public class DayMessageController {

	private static final Logger logger = LoggerFactory.getLogger(DayMessageController.class);	
	
	@Autowired
	private IDayMessageService dayMessageService;
	
	
	/**
	 * 保存每日信息
	 * @param dayMessageModel
	 * @return
	 */
	@RequestMapping(value = "/dayMessage/save", method = {RequestMethod.POST})
	public DataResponse saveDayMessage(DayMessageModel dayMessageModel){
		DataResponse dr = null;
		try {
			dayMessageService.saveDayMessage(dayMessageModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("保存每日信息异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 查询‘每日信息’列表
	 * 当参数day为all时，表示查询所有天数信息列表； 当为now时，表示查询当天信息列表
	 * @return
	 */
	@RequestMapping(value = "/dayMessage/query/allday", method = {RequestMethod.POST})
	public DataResponse queryAllDayMessage(@RequestParam(name="day", required=true, defaultValue="now")String day){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = dayMessageService.queryAllDayMessage(day);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询每日信息列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	
}
