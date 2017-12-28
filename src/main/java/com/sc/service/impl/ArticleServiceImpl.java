package com.sc.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.ScException;
import com.sc.common.util.DateUtil;
import com.sc.dao.ArticleMapper;
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
		
	}

	@Override
	public Map<String, Object> queryAllArticle(String day) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(StringUtils.equalsIgnoreCase(day, CommonConstant.ALL)){
			//查询所有天数
			
		}else if(StringUtils.equalsIgnoreCase(day, CommonConstant.NOW)){  
			//查询当天
			String nowDay = DateUtil.date2Str2(new Date());
			
		}else{
			logger.warn("day参数：{}，传入错误", day);
			throw new ScException("参数有误");
		}
		return dataMap;
	}

	
	
}
