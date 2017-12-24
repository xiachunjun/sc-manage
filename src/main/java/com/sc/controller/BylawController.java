package com.sc.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.sc.common.util.FileUtil;
import com.sc.model.request.BylawModel;
import com.sc.service.IBylawService;

/**
 * 规章制度（基本完成，不妥之处再进行修改）
 */
@RestController
public class BylawController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(BylawController.class);
	
	@Autowired
	private IBylawService bylawService;
	
	/**
	 * 新增规章制度
	 * @param bylawSaveModel
	 * @return
	 */
	@RequestMapping(value = "/bylaw/save", method = {RequestMethod.POST})
	public DataResponse saveBylaw(BylawModel bylawModel, 
			@RequestParam(name="file", required=true)MultipartFile file, HttpServletRequest request){
		DataResponse dr = new DataResponse();
		try {
			bylawService.saveBylaw(bylawModel, file, request);
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("新增规章制度出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	/**
	 * 查询规章制度列表
	 * @return
	 */
	@RequestMapping(value = "/bylaw/query/list", method = {RequestMethod.POST})
	public DataResponse queryBylaw(){
		DataResponse dr = new DataResponse();
		try {
			Map<String, Object> dataMap = bylawService.queryBylawList();
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
			dr.setDataMap(dataMap);
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("查询规章制度出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	/**
	 * 修改规章制度
	 * @param bylawSaveModel
	 * @return
	 */
	@RequestMapping(value = "/bylaw/update", method = {RequestMethod.POST})
	public DataResponse updateBylaw(BylawModel bylawModel,
			@RequestParam(name="file", required=false)MultipartFile file, HttpServletRequest request){
		DataResponse dr = new DataResponse();
		try {
			bylawService.updateBylaw(bylawModel, file, request);
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("修改规章制度出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	/**
	 * 删除规章制度
	 * @param bylawsCode
	 * @return
	 */
	@RequestMapping(value = "/bylaw/delete", method = {RequestMethod.POST})
	public DataResponse deleteBylaw(@RequestParam(name="bylawsId", required=true)Integer bylawsId){
		DataResponse dr = new DataResponse();
		try {
			bylawService.deleteBylaw(bylawsId);
			dr.setResultCode(ResponseEnum.RESPONSE_SUCCESS.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_SUCCESS.getMsg());
		} catch (MyException e) {
			logger.error(e.getMessage());
			dr.setResultCode(ResponseEnum.RESPONSE_FAIL.getCode());
			dr.setResultMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("修改规章制度出现异常", e);
			dr.setResultCode(ResponseEnum.RESPONSE_ERROR_SYSTEM.getCode());
			dr.setResultMessage(ResponseEnum.RESPONSE_ERROR_SYSTEM.getMsg());
		}
		return dr;
	}
	
	
	/**
	 * 下载文件
	 * @param bylawsCode
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/bylaw/download", method = {RequestMethod.POST, RequestMethod.GET})
	public void downloadFile(@RequestParam(name="bylawsId", required=true)Integer bylawsId,
			HttpServletRequest request, HttpServletResponse response){
		String filePath = bylawService.queryFileUrlById(bylawsId);
		if(StringUtils.isEmpty(filePath)){
			logger.warn("该主键id:{}，对应的文件路径为空", bylawsId);
		}else{
		    File file = new File(filePath);
		    if (file.exists()) {
		    	String fileName = StringUtils.substringAfterLast(filePath, "/");
		    	FileUtil.downloadFile(response, file, fileName);
		    }else{
		    	logger.warn("该文件路径：{}，不存在", file.getPath());
		    }
		}
	}

	
}
