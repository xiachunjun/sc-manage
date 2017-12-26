package com.sc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.domain.Department;
import com.sc.service.IDepartmentService;

/**
 * 部门
 */
@RestController
public class PositionController {

	private static final Logger logger = LoggerFactory.getLogger(PositionController.class);


	/**
	 * 查询所有部门
	 * 
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/position/queryAll", method = { RequestMethod.POST })
	public DataResponse queryDepartmentList() {
		DataResponse dr = null;
		try {
//			List<Department> depts = departmentService.queryAllDepartment();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询部门列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

}
