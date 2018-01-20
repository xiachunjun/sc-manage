package com.sc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.model.request.DataRecordModel;
import com.sc.service.IDataRecordService;

/**
 * 数据填报
 */
@Controller
public class DataRecordController {

	private static final Logger logger = LoggerFactory.getLogger(DataRecordController.class);
	
	@Autowired
	private IDataRecordService dataRecordService;
	
	/**
	 * 保存数据填报
	 */
	@RequestMapping(value = "/dataRecord/save", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse saveDataRecord(@RequestBody List<DataRecordModel> dataRecordModels) {
		DataResponse dr = null;
		try {
			dataRecordService.saveDataRecord(dataRecordModels);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("保存数据填报异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
}
