package com.sc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.domain.Position;
import com.sc.model.request.PositionModel;
import com.sc.service.IPositionService;

/**
 * 部门
 */
@RestController
public class PositionController {

	private static final Logger logger = LoggerFactory.getLogger(PositionController.class);

	@Autowired
	IPositionService positionService;

	/**
	 * 查询所有职位
	 * 
	 * @return
	 */
	@RequestMapping(value = "/position/queryAll", method = { RequestMethod.POST })
	public DataResponse queryPositionList() {
		DataResponse dr = null;
		try {
			List<Position> pos = positionService.queryAllPosition();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("positions", pos);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询职位列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	/**
	 * 查询所有部门
	 * 
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/position/queryByDeptCode", method = { RequestMethod.POST })
	public DataResponse queryByDeptCode(@RequestBody PositionModel positionModel) {
		DataResponse dr = null;
		try {
			List<Position> pos = positionService.queryByDeptCode(positionModel.getDepartmentCode());
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("positions", pos);
		}catch (Exception e) {
			logger.error("通过部门编号查询职位列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

}
