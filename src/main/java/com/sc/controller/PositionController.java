package com.sc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.domain.PositionDomain;
import com.sc.model.request.PositionModel;
import com.sc.service.IPositionService;
import com.sc.support.ValidatedGroup1;
import com.sc.support.ValidatedGroup2;
import com.sc.support.ValidatedGroup3;

/**
 * 部门
 */
@RestController
public class PositionController {

	private static final Logger logger = LoggerFactory.getLogger(PositionController.class);

	@Autowired
	private IPositionService positionService;

	/**
	 * 新增岗位
	 */
	@RequestMapping(value = "/position/add", method = { RequestMethod.POST })
	public DataResponse savePosition(@RequestBody @Validated(value = { ValidatedGroup2.class}) PositionModel positionModel) {
		DataResponse dr = null;
		try {
			positionService.savePosition(positionModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.error("新增岗位异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 查询所有岗位列表
	 */
	@RequestMapping(value = "/position/queryPosiList", method = { RequestMethod.POST })
	public DataResponse queryAllPosi() {
		DataResponse dr = null;
		try {
			List<PositionDomain> pos = positionService.queryPosiList();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("positions", pos);
		} catch (Exception e) {
			logger.error("通过部门编号查询职位列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 根据部门id，查询岗位列表
	 */
	@RequestMapping(value = "/position/queryByDept", method = { RequestMethod.POST })
	public DataResponse queryByDept(@RequestBody @Validated(value = { ValidatedGroup3.class}) PositionModel positionModel) {
		DataResponse dr = null;
		try {
			List<PositionDomain> pos = positionService.queryListByDeptId(positionModel.getRefDeptId());
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("positions", pos);
		} catch (Exception e) {
			logger.error("通过部门编号查询职位列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 修改岗位
	 */
	@RequestMapping(value = "/position/update", method = { RequestMethod.POST })
	public DataResponse updatePosition(@Validated(value = { ValidatedGroup1.class,ValidatedGroup2.class} )PositionModel positionModel) {
		DataResponse dr = null;
		try {
			positionService.updatePosition(positionModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.error("修改岗位异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 删除岗位
	 */
	@RequestMapping(value = "/position/delete", method = { RequestMethod.POST })
	public DataResponse deletePosition(@RequestBody @Validated(value = { ValidatedGroup1.class} )PositionModel positionModel) {
		DataResponse dr = null;
		try {
			positionService.deletePosition(positionModel.getId());
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.error("删除岗位异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

}
