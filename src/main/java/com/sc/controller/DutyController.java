package com.sc.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.service.IDutyService;

@Controller
public class DutyController {

	private static final Logger logger = LoggerFactory.getLogger(DutyController.class);

	@Autowired
	private IDutyService dutyService;

	@RequestMapping("/duty/dutyList")
	public String dutyList(Map<String, Object> map) {
		return "/dutyList";
	}

	@RequestMapping("/duty/deptDutyList")
	public ModelAndView deptDutyList(@RequestParam Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("dutyDetail");
		map.put("dutyTypeName", "部门");
		map.put("dutyEntityType", "DEPT");
		map.put("dutyEntityCode", map.get("deptCode"));
		map.put("dutyEntityName", map.get("deptName"));
		mv.addAllObjects(map);
		return mv;
	}

	@RequestMapping("/duty/posiDutyList")
	public ModelAndView posiDutyList(@RequestParam Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("dutyDetail");
		map.put("dutyTypeName", "岗位");
		map.put("dutyEntityType", "POSI");
		map.put("dutyEntityCode", map.get("posiCode"));
		map.put("dutyEntityName", map.get("posiName"));
		mv.addAllObjects(map);
		return mv;
	}

	/**
	 * 根据部门code, 查询一二级职责
	 */
	@RequestMapping(value = "/duty/queryByCondition", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse queryDutyByDeptCode(@RequestParam(name = "dutyEntityCode", required = true) String dutyEntityCode,@RequestParam(name = "dutyEntityType", required = true) String dutyEntityType) {
		DataResponse dr = null;
		try {
			List<Map<String, Object>> dataMap =null;
			if("DEPT".equals(dutyEntityType)){
				dataMap=dutyService.queryDutyByDeptCode(dutyEntityCode);
			}else if("POSI".equals(dutyEntityType)){
				dataMap=dutyService.queryDutyByPosiCode(dutyEntityCode);
			}
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("dutyList", dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询一二级职责异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 根据岗位code, 查询一二级职责
	 */
	@RequestMapping(value = "/duty/queryByPostCode", method = { RequestMethod.POST })
	@ResponseBody
	public DataResponse queryDutyByPostCode(@RequestParam(name = "posiCode", required = true) String posiCode) {
		DataResponse dr = null;
		try {
//			List<Map<String, Object>> dataMap = dutyService.queryDutyByPostCode(posiCode);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
//			dr.put("posiDutyList", dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("根据岗位code, 查询一二级职责异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

}
