package com.sc.service;

import java.util.List;
import java.util.Map;

import com.sc.domain.BylawDomain;
import com.sc.model.request.BylawModel;

public interface IBylawService {

	/**
	 * 新增规章制度
	 * @param bylawModel
	 * @param file
	 * @param request
	 */
	void saveBylaw(BylawModel bylawModel);

	/**
	 * 查询规章制度
	 * @return
	 */
	Map<String, List<BylawDomain>> queryBylawList();

	/**
	 * 修改规章制度
	 * @param bylawModel
	 * @param file
	 * @param request
	 */
	void updateBylaw(BylawModel bylawModel);

	/**
	 * 删除规章制度
	 * @param bylawsId
	 */
	void deleteBylaw(Integer bylawsId);

	/**
	 * 根据id，查询规章制度
	 * @param id
	 * @return
	 */
	BylawDomain queryById(Integer id);

	/**
	 * 查询各个类型规章制度的数量
	 * @return
	 */
	Map<String, Object> queryCountGroupBylawCategory();

	
}
