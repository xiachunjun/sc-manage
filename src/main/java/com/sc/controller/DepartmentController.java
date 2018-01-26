package com.sc.controller;

import java.util.List;

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
import com.sc.domain.DepartmentDomain;
import com.sc.model.request.DepartmentModel;
import com.sc.model.response.DeptPosiResult;
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
	 * 新增部门
	 */
	@RequestMapping(value = "/department/add", method = { RequestMethod.POST })
	public DataResponse saveDepartment(DepartmentModel departmentModel) {
		DataResponse dr = null;
		try {
			departmentService.saveDepartment(departmentModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.error("新增部门异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 查询所有部门
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

	
	/**
	 * 查询各部门对应岗位列表
	 * @return
	 */
	@RequestMapping(value = "/position/queryDeptPosiList", method = { RequestMethod.POST })
	public DataResponse queryDeptPosiList() {
		DataResponse dr = null;
		try {
			List<DeptPosiResult> dept = departmentService.queryDeptPosiList();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("depts", dept);
		} catch (Exception e) {
			logger.error("查询各部门对应岗位列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	
	/**
	 * 修改部门
	 */
	@RequestMapping(value = "/department/update", method = { RequestMethod.POST })
	public DataResponse updateDepartment(DepartmentModel departmentModel) {
		DataResponse dr = null;
		try {
			departmentService.updateDepartment(departmentModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.error("修改部门异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 删除部门
	 */
	@RequestMapping(value = "/department/delete", method = { RequestMethod.POST })
	public DataResponse deleteDepartment(@RequestParam(name="id", required=true)Integer id) {
		DataResponse dr = null;
		try {
			departmentService.deleteDepartmentById(id);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.error("删除部门异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	
}
