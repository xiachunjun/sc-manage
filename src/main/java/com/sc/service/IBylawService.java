package com.sc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.sc.domain.Bylaw;
import com.sc.model.request.BylawModel;

public interface IBylawService {

	/**
	 * 新增规章制度
	 * @param bylawModel
	 * @param file
	 * @param request
	 */
	void saveBylaw(BylawModel bylawModel, MultipartFile file, HttpServletRequest request, String userLoginName);

	/**
	 * 查询规章制度
	 * @return
	 */
	Map<String, Object> queryBylawList();

	/**
	 * 修改规章制度
	 * @param bylawModel
	 * @param file
	 * @param request
	 */
	void updateBylaw(BylawModel bylawModel, MultipartFile file, HttpServletRequest request, String userLoginName);

	/**
	 * 删除规章制度
	 * @param bylawsId
	 */
	void deleteBylaw(Integer bylawsId);

	/**
	 * 根据业务主键， 获取文件的存储路径
	 * @param bylawsId
	 * @return
	 */
	String queryFileUrlById(Integer bylawsId);

	/**
	 * 根据id，查询规章制度
	 * @param id
	 * @return
	 */
	Bylaw queryById(Integer id);

	/**
	 * 查询各个类型规章制度的数量
	 * @return
	 */
	Map<String, Object> queryCountGroupBylawCategory();

	
}
