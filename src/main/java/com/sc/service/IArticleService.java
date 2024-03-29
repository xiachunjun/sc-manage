package com.sc.service;

import java.util.List;
import java.util.Map;

import com.sc.model.request.ArticleModel;

public interface IArticleService {

	/**
	 * 保存每日信息
	 * @param articleModel
	 */
	void saveArticle(ArticleModel articleModel);

	/**
	 * 查询所有每日信息列表
	 * @param day
	 * @return
	 */
	Map<String, Object> queryAllArticle(String day);

	/**
	 * 查询内容详情
	 * @param id
	 * @param queryTime
	 * @return
	 */
	List<String> queryArticleContent(Integer id, String queryTime);

	/**
	 * 查询待审批信息
	 * @param userLoginName
	 * @return
	 */
	Map<String, Object> queryNotAuditArticle(String userLoginName);

	/**
	 * 签发
	 * @param id
	 * @param signUserCheckState
	 */
	void auditArticle(Integer id, String signUserCheckState);

	
}
