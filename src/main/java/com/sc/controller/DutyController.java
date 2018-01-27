package com.sc.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.model.request.DutySaveModel;
import com.sc.model.request.QueryDeptPosiDutyModel;
import com.sc.model.request.QueryDutyModel;
import com.sc.model.request.UpdateDutyModel;
import com.sc.model.response.DutyResult;
import com.sc.service.IDutyService;

@RestController
public class DutyController {

	private static final Logger logger = LoggerFactory.getLogger(DutyController.class);

	@Autowired
	private IDutyService dutyService;

	/**
	 * 新增责任清单
	 */
	@RequestMapping(value = "/duty/add", method = { RequestMethod.POST })
	public DataResponse saveDuty(@RequestBody @Valid DutySaveModel dutySaveModel) {
		DataResponse dr = null;
		try {
			dutyService.saveDuty(dutySaveModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("新增责任清单异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 条件查询，查询部门与岗位责任清单
	 * userId:责任人，  deptId:部门，   posiId:岗位
	 */
	@RequestMapping(value = "/duty/queryByCondition", method = { RequestMethod.POST })
	public DataResponse queryDutyByCondition(@RequestBody QueryDutyModel queryDutyModel) {
		DataResponse dr = null;
		try {
			List<DutyResult> list = dutyService.queryDutyByCondition(queryDutyModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("dutyList", list);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询责任清单列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	

	/**
	 * 根据部门id 或 岗位id, 查询各自的一二级职责;  直接跳转到一二级职责详情页面
	 * qId: 为部门或岗位id
	 * type: DEPT表示部门，  POSI表示岗位
	 */
	@RequestMapping(value = "/duty/queryByType", method = { RequestMethod.POST })
	public DataResponse queryDutyByDeptId(@RequestBody @Valid QueryDeptPosiDutyModel queryDeptPosiDutyModel) {
		DataResponse dr = null;
		try {
			//一二级职责
			List<Map<String, Object>> dataMapList = dutyService.queryDutyByType(queryDeptPosiDutyModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("dutyList", dataMapList);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("根据部门id或岗位id, 查询各自的一二级职责异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	
	/**
	 * 修改责任清单
	 */
	@RequestMapping(value = "/duty/update", method = { RequestMethod.POST })
	public DataResponse updateDuty(List<UpdateDutyModel> models) {
		DataResponse dr = null;
		try {
			if(CollectionUtils.isEmpty(models)){
				return new DataResponse(ResponseEnum.RESPONSE_ERROR_PARAM);
			}
			dutyService.updateDuty(models);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("修改责任清单异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 删除责任清单
	 */
	@RequestMapping(value = "/duty/delete", method = { RequestMethod.POST })
	public DataResponse deleteDuty(@RequestParam(name="id", required=true)Integer id) {
		DataResponse dr = null;
		try {
			dutyService.deleteDutyById(id);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("删除责任清单异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
}
