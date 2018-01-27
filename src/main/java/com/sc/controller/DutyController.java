package com.sc.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.model.request.DutySaveModel;
import com.sc.model.request.UpdateDutyModel;
import com.sc.model.response.DutyResult;
import com.sc.service.IDutyService;

@Controller
public class DutyController {

	private static final Logger logger = LoggerFactory.getLogger(DutyController.class);

	@Autowired
	private IDutyService dutyService;

	/**
	 * 新增责任清单
	 */
	@RequestMapping(value = "/duty/add", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse saveDuty(DutySaveModel dutySaveModel) {
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
	@ResponseBody
	public DataResponse queryDutyByCondition(Integer userId, Integer deptId, Integer posiId) {
		DataResponse dr = null;
		try {
			List<DutyResult> list = dutyService.queryDutyByCondition(userId, deptId, posiId);
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
	 * 跳转到部门或岗位的一二级职责页面
	 */
	@RequestMapping(value = "/to/duty/detail", method = { RequestMethod.GET })
	public ModelAndView toDutyDetail(@RequestParam(name="qId", required=true)Integer qId,
			@RequestParam(name="type", required=true)String type,
			@RequestParam Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/duty/dutyDetail");
		if(StringUtils.equals("DEPT", type)){
			map.put("dutyTypeName", "部门");
		}else if(StringUtils.equals("POSI", type)){
			map.put("dutyTypeName", "岗位");
		}
		map.put("dutyEntityType", type);
		map.put("dutyEntityCode", qId);
		map.put("dutyEntityName", map.get("name"));
		mv.addAllObjects(map);
		return mv;
	}
	
	/**
	 * 根据部门id 或 岗位id, 查询各自的一二级职责;  直接跳转到一二级职责详情页面
	 * qId: 为部门或岗位id
	 * type: DEPT表示部门，  POSI表示岗位
	 */
	@RequestMapping(value = "/duty/queryByType", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse queryDutyByDeptId(@RequestParam(name="qId", required=true)Integer qId,
			@RequestParam(name="type", required=true)String type) {
		DataResponse dr = null;
		try {
			//一二级职责
			List<Map<String, Object>> dataMapList = dutyService.queryDutyByType(qId, type);
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
	@ResponseBody
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
	@ResponseBody
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
