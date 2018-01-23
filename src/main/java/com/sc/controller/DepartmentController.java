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
import com.sc.domain.DepartmentDomain;
import com.sc.service.IDepartmentService;

/**
 * 部门
 */
@RestController
public class DepartmentController {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private IDepartmentService departmentService;

	/**
	 * 查询所有部门
	 * 
	 * @param positionModel
	 * @return
	 */
	@RequestMapping(value = "/department/queryDeptList", method = { RequestMethod.POST })
	public DataResponse queryDeptList() {
		DataResponse dr = null;
		try {
			List<DepartmentDomain> depts = departmentService.queryByDataState(1);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("depts", depts);
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
