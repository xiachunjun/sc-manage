package com.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.ScException;
import com.sc.common.util.DateUtil;
import com.sc.dao.ArticleMapper;
import com.sc.domain.Article;
import com.sc.model.request.ArticleModel;
import com.sc.service.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService {

	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);	
	
	@Autowired
	private ArticleMapper articleMapper;
	
	
	@Transactional
	@Override
	public void saveArticle(ArticleModel articleModel) {
		Article record = setArticleProperty(articleModel);
		int flag = articleMapper.saveArticle(record);
		if (flag != 1) {
			throw new ScException("保存每日信息出错");
		}
	}


	@Override
	public Map<String, Object> queryAllArticle(String day) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(StringUtils.equalsIgnoreCase(day, CommonConstant.ALL)){
			//每一天的所有信息的map
			Map<String, List<Article>> everyDayMap = new LinkedHashMap<String, List<Article>>();
			//按天分组，查询所有天数
			List<Article> list = articleMapper.queryArticle();
			//查询所有信息列表
			List<String> artTimeList = articleMapper.queryGroupByArticleTime();
			if(!CollectionUtils.isEmpty(artTimeList)){
				for (String artTime : artTimeList) {
					if(!CollectionUtils.isEmpty(list)){
						//每一天的所有信息列表
						List<Article> resultList = new ArrayList<Article>();
						for (Article article : list) {
							String queryTime = DateUtil.date2Str2(article.getArticleTime());
							if(StringUtils.equals(artTime, queryTime)){
								resultList.add(article);
							}
						}
						everyDayMap.put(artTime, resultList);
					}
				}
			}
			dataMap.put("articleList", everyDayMap);
		}else if(StringUtils.equalsIgnoreCase(day, CommonConstant.NOW)){  
			//查询当天
			dataMap.put("articleList", articleMapper.queryNowDayArticle());
		}else{
			logger.warn("day参数：{}，传入错误", day);
			throw new ScException("参数有误");
		}
		return dataMap;
	}

	
	@Override
	public List<String> queryArticleContent(Integer id, String queryTime) {
		List<String> articleContentList = null ;
		if(StringUtils.isNoneBlank(queryTime)){
			//查询一天所有的记录
			articleContentList = articleMapper.queryArticleContentsByArticleTime(queryTime);
		}else{
			//查询具体的一条记录
			articleContentList = articleMapper.queryArticleContentById(id);
		}
		return articleContentList;
	}
	
	
	/************************以下为私有方法************************/
	
	private Article setArticleProperty(ArticleModel articleModel) {
		Article record = new Article();
		BeanUtils.copyProperties(articleModel, record);
		record.setArticleTime(DateUtil.str2Date(articleModel.getArtTime()));
		record.setId(null);
		record.setDataState(1);
		record.setDataVersion(1);
		record.setCreateUser("SYS");
		record.setUpdateUser(record.getCreateUser());
		record.setCreateTime(new Date());
		record.setUpdateTime(record.getCreateTime());
		return record;
	}
	
	
}
