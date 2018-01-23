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
import com.sc.domain.PositionDomain;
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
	 * 根据部门编号，查询岗位列表
	 * 
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/position/addPosition", method = { RequestMethod.POST })
	public DataResponse addPosition(@RequestBody PositionModel positionModel) {
		DataResponse dr = null;
		try {
			List<PositionDomain> pos = positionService.queryByDept(positionModel.getRefDeptId());
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("positions", pos);
		} catch (Exception e) {
			logger.error("通过部门编号查询职位列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 根据部门编号，查询岗位列表
	 * 
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/position/queryByDept", method = { RequestMethod.POST })
	public DataResponse queryByDept(@RequestBody PositionModel positionModel) {
		DataResponse dr = null;
		try {
			List<PositionDomain> pos = positionService.queryByDept(positionModel.getRefDeptId());
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("positions", pos);
		} catch (Exception e) {
			logger.error("通过部门编号查询职位列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

}
