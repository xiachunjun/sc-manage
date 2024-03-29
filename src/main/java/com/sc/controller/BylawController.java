package com.sc.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.common.util.DateUtil;
import com.sc.common.util.FileUtil;
import com.sc.domain.BylawDomain;
import com.sc.model.request.BylawModel;
import com.sc.service.IBylawService;
import com.sc.support.ValidatedGroup1;

/**
 * 规章制度
 */
@RestController
public class BylawController {

	private static final Logger logger = LoggerFactory.getLogger(BylawController.class);
	
	@Value("${system.file.path}")
	private String filePath; // 上传的附件的存储路径
	@Autowired
	private IBylawService bylawService;

	
	/**
	 * 新增规章制度
	 */
	@RequestMapping(value = "/bylaw/save", method = { RequestMethod.POST })
	public DataResponse saveBylaw(BylawModel bylawModel, HttpServletRequest request) {
		DataResponse dr = null;
		try {
			// 这里的文件校验工作可以自定义校验器，省事，所以先这么写
			if (bylawModel.getFile() == null) {
				dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
				dr.put(CommonConstant.FAILED_MSG, "附件文件不能为空！");
				return dr;
			}
			String fileUrl = this.uploadFile(bylawModel.getFile());
			bylawModel.setFile(null);
			bylawModel.setFileUrl(fileUrl);
			bylawService.saveBylaw(bylawModel);
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
	 */
	@RequestMapping(value = "/bylaw/query/list", method = { RequestMethod.POST })
	public DataResponse queryBylaw() {
		DataResponse dr = null;
		try {
			Map<String, List<BylawDomain>> dataMap = bylawService.queryBylawList();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("bylawList", dataMap);
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
	 */
	@RequestMapping(value = "/bylaw/update", method = { RequestMethod.POST })
	public DataResponse updateBylaw(BylawModel bylawModel, HttpServletRequest request) {
		DataResponse dr = null;
		try {
			if (bylawModel.getId() == null || bylawModel.getId() == 0) {
				dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
				dr.put(CommonConstant.FAILED_MSG, "记录ID不能为空！");
				return dr;
			}
			if(null != bylawModel.getFile()){
				String fileUrl=this.uploadFile(bylawModel.getFile());
				bylawModel.setFile(null);
				bylawModel.setFileUrl(fileUrl);
			}
			bylawService.updateBylaw(bylawModel);
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
	 */
	@RequestMapping(value = "/bylaw/delete", method = { RequestMethod.POST })
	public DataResponse deleteBylaw(@RequestBody  @Validated(value={ValidatedGroup1.class}) BylawModel bylawModel) {
		DataResponse dr = null;
		try {
			bylawService.deleteBylaw(bylawModel.getId());
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
	 */
	@RequestMapping(value = "/bylaw/download", method = { RequestMethod.GET })
	public void downloadFile(@RequestParam(name="id", required=true)Integer id,
			HttpServletRequest request, HttpServletResponse response) {
		BylawDomain bylawDomain = bylawService.queryById(id);
		if (null == bylawDomain || StringUtils.isEmpty(bylawDomain.getFileUrl())) {
			logger.warn("该主键id:{}，对应的文件路径为空", id);
		} else {
			File file = new File(bylawDomain.getFileUrl());
			if (file.exists()) {
				String fileName = StringUtils.substringAfterLast(bylawDomain.getFileUrl(), "/");
				FileUtil.downloadFile(response, file, fileName);
			} else {
				logger.warn("该文件路径：{}，不存在", file.getPath());
			}
		}
	}
	

	/**
	 * 根据id,查询规章制度
	 */
	@RequestMapping(value = "/bylaw/queryById", method = { RequestMethod.POST })
	public DataResponse queryById(@RequestBody  @Validated(value={ValidatedGroup1.class}) BylawModel bylawModel) {
		DataResponse dr = null;
		try {
			BylawDomain bylawDomain = bylawService.queryById(bylawModel.getId());
			if (null == bylawDomain) {
				dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_NULL);
			} else {
				dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
				dr.put("bylaw", bylawDomain);
			}
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("根据id, 查询规章制度异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	
	/**
	 * 查询各个类型规章制度的数量
	 */
	@RequestMapping(value = "/bylaw/queryCountByCategory", method = { RequestMethod.POST })
	public DataResponse queryCountGroupBylawCategory() {
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = bylawService.queryCountGroupBylawCategory();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询各个类型规章制度的数量异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	
	/******************以下为私有方法******************/
	
	private String uploadFile(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String realFilePath = filePath + DateUtil.generateStr(new Date()) + "/";
		try {
			FileUtil.uploadFile(file.getBytes(), realFilePath, fileName);
		} catch (Exception e) {
			logger.error("上传附件置服务器异常", e);
			throw new ScException("保存上传附件出错");
		}
		return realFilePath + fileName;
	}
	
}
