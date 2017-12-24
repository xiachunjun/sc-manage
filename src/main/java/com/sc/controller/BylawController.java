package com.sc.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.common.util.FileUtil;
import com.sc.model.request.BylawModel;
import com.sc.service.IBylawService;

/**
 * 规章制度（基本完成，不妥之处再进行修改）
 */
@RestController
public class BylawController {

	private static final Logger logger = LoggerFactory.getLogger(BylawController.class);

	@Autowired
	private IBylawService bylawService;

	/**
	 * 新增规章制度
	 * 
	 * @param bylawSaveModel
	 * @return
	 */
	@RequestMapping(value = "/bylaw/save", method = { RequestMethod.POST })
	public DataResponse saveBylaw(@Valid BylawModel bylawModel, HttpServletRequest request) {
		DataResponse dr = null;
		try {
			//这里的文件校验工作可以自定义校验器，省事，所以先这么写
			if (bylawModel.getFile() == null) {
				dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
				dr.put(CommonConstant.FAILED_MSG, "附件文件不能为空！");
				return dr;
			}
			bylawService.saveBylaw(bylawModel, bylawModel.getFile(), request);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("新增规章制度出现异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 查询规章制度列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/bylaw/query/list", method = { RequestMethod.POST })
	public DataResponse queryBylaw() {
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = bylawService.queryBylawList();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询规章制度出现异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 修改规章制度
	 * 
	 * @param bylawSaveModel
	 * @return
	 */
	@RequestMapping(value = "/bylaw/update", method = { RequestMethod.POST })
	public DataResponse updateBylaw(BylawModel bylawModel, HttpServletRequest request) {
		DataResponse dr = null;
		try {
			if(bylawModel.getId() == null || bylawModel.getId() == 0){
				dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
				dr.put(CommonConstant.FAILED_MSG, "记录ID不能为空！");
				return dr;
			}
			bylawService.updateBylaw(bylawModel, bylawModel.getFile(), request);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("修改规章制度出现异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 删除规章制度
	 * 
	 * @param bylawsCode
	 * @return
	 */
	@RequestMapping(value = "/bylaw/delete", method = { RequestMethod.POST })
	public DataResponse deleteBylaw(@RequestParam(name = "bylawsId", required = true) Integer bylawsId) {
		DataResponse dr = null;
		try {
			bylawService.deleteBylaw(bylawsId);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("修改规章制度出现异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 下载文件
	 * 
	 * @param bylawsCode
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/bylaw/download", method = { RequestMethod.POST })
	public void downloadFile(@RequestParam(name = "bylawsId", required = true) Integer bylawsId,
			HttpServletRequest request, HttpServletResponse response) {
		String filePath = bylawService.queryFileUrlById(bylawsId);
		if (StringUtils.isEmpty(filePath)) {
			logger.warn("该主键id:{}，对应的文件路径为空", bylawsId);
		} else {
			File file = new File(filePath);
			if (file.exists()) {
				String fileName = StringUtils.substringAfterLast(filePath, "/");
				FileUtil.downloadFile(response, file, fileName);
			} else {
				logger.warn("该文件路径：{}，不存在", file.getPath());
			}
		}
	}

}
