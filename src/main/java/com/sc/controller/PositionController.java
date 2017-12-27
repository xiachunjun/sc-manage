package com.sc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.CommonConstant;
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

	
	/**
	 * TODO 新增责任清单
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/position/save", method = {RequestMethod.POST})
	public DataResponse savePosition(PositionModel positionModel, HttpServletRequest request){
		DataResponse dr = null;
		try {
			String userLoginName = String.valueOf(request.getSession().getAttribute(CommonConstant.USER_LOGIN_NAME));
			positionService.savePosition(positionModel, userLoginName);
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
	 * 条件查询责任清单； 没有输入条件，则查询所有
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/position/query/list", method = {RequestMethod.POST})
	public DataResponse queryPositionByCondition(@RequestBody PositionModel positionModel){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = positionService.queryPositionByCondition(positionModel);
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
	@RequestMapping(value = "/position/update", method = {RequestMethod.POST})
	public DataResponse updatePosition(@RequestBody PositionModel positionModel, HttpServletRequest request){
		DataResponse dr = null;
		try {
			if(positionModel.getId() == null || positionModel.getId() == 0){
				dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
				dr.put(CommonConstant.FAILED_MSG, "记录ID不能为空！");
				return dr;
			}
			String userLoginName = String.valueOf(request.getSession().getAttribute(CommonConstant.USER_LOGIN_NAME));
			positionService.updatePosition(positionModel, userLoginName);
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
	
	
}
