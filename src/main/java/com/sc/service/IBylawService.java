package com.sc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.sc.model.request.BylawModel;

public interface IBylawService {

	/**
	 * 新增规则制度
	 * @param bylawModel
	 */
	void saveBylaw(BylawModel bylawModel, MultipartFile file, HttpServletRequest request);

	/**
	 * 查询规则制度
	 * @return
	 */
	Map<String, Object> queryBylaw();

	/**
	 * 修改规则制度
	 * @param bylawModel
	 */
	void updateBylaw(BylawModel bylawModel);

	/**
	 * 删除规则制度
	 * @param bylawsCode
	 */
	void deleteBylaw(String bylawsCode);

}
