package com.sc.service;

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

	
}
