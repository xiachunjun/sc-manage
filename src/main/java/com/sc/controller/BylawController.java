package com.sc.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sc.common.constant.DataResponse;
import com.sc.common.constant.MyException;
import com.sc.common.constant.ResponseEnum;
import com.sc.model.request.BylawModel;
import com.sc.service.IBylawService;

/**
 * 规则制度
 */
@RestController
public class BylawController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(BylawController.class);
	
	@Autowired
	private IBylawService bylawService;
	
	/**
	 * 新增规则制度
	 * @param bylawSaveModel
	 * @return
	 */
	@RequestMapping(value = "/bylaw/save", method = {RequestMethod.POST})
	public DataResponse saveBylaw(BylawModel bylawModel, 
			@RequestParam(name="file", required=false)MultipartFile file, HttpServletRequest request){
		DataResponse dr = new DataResponse();
		//@Valid BylawModel bylawModel, BindingResult br
//		if(null != hasErrors(br)){
//			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_PARAM.getCode());
//			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_PARAM.getMsg());
//			return dr;
//		}
		try {
			bylawModel.setBylawsCategory("条件保障");  //条件保障，财务管理
			bylawModel.setBylawsName("规则制度---名称");
			bylawModel.setBylawsNo("规则制度---编号");
			bylawModel.setArticleNo("规则制度---发文文号");
			bylawModel.setArticleTime(new Date());
			
			bylawService.saveBylaw(bylawModel, file, request);
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("新增规则制度出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	/**
	 * 查询规则制度
	 * @return
	 */
	@RequestMapping(value = "/bylaw/query", method = {RequestMethod.POST})
	public DataResponse queryBylaw(){
		DataResponse dr = new DataResponse();
		try {
			Map<String, Object> dataMap = bylawService.queryBylaw();
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
			dr.setDataMap(dataMap);
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("查询规则制度出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	/**
	 * 修改规则制度
	 * @param bylawSaveModel
	 * @return
	 */
	@RequestMapping(value = "/bylaw/update", method = {RequestMethod.POST})
	public DataResponse updateBylaw(BylawModel bylawModel){
		DataResponse dr = new DataResponse();
		try {
			bylawModel.setBylawsCode("100000");
			bylawService.updateBylaw(bylawModel);
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("修改规则制度出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	/**
	 * 删除规则制度
	 * @param bylawsCode
	 * @return
	 */
	@RequestMapping(value = "/bylaw/delete", method = {RequestMethod.POST})
	public DataResponse deleteBylaw(String bylawsCode){
		DataResponse dr = new DataResponse();
		try {
			bylawService.deleteBylaw(bylawsCode);
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("修改规则制度出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
}
