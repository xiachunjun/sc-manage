package com.sc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sc.common.constant.ScException;
import com.sc.dao.ArticleMapper;
import com.sc.domain.ArticleDomain;
import com.sc.model.request.ArticleModel;
import com.sc.service.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService {

	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);	
	
//	@Autowired
//	private ArticleMapper articleMapper;
	
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void saveArticle(ArticleModel articleModel) {
		ArticleDomain articleDomain = new ArticleDomain();
		BeanUtils.copyProperties(articleModel, articleDomain);
//		int flag = articleMapper.insert(articleDomain);
//		if (flag != 1) {
//			throw new ScException("保存每日信息出错");
//		}
	}

	@Override
	public Map<String, Object> queryNotAuditArticle(String userLoginName) {
		//TODO 院办公室可见，审批流上的领导可见, 如果登录用户是院办公室人，也可以查询到
		Map<String, Object> dataMap = new HashMap<String, Object>();
//		dataMap.put("articleList", articleMapper.queryNotAuditArticle(userLoginName));
		return dataMap;
	}
	
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void auditArticle(Integer id, String userLoginName) {
//		Article article = articleMapper.queryById(id);
//		if(null != article){
//			//只有签发人可以签发
//			if(StringUtils.equals(userLoginName, article.getArticleSignUser())){
//				int flag = articleMapper.updateDataState(id);
//				if(flag != 1){
//					throw new ScException("签发信息出错");
//				}
//			}
//		}
		
	}
	
	

	@Override
	public Map<String, Object> queryAllArticle(String day) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
//		if(StringUtils.equalsIgnoreCase(day, CommonConstant.ALL)){
//			//每一天的所有信息的map
//			Map<String, List<Article>> everyDayMap = new LinkedHashMap<String, List<Article>>();
//			//按天分组，查询所有天数
//			List<Article> list = articleMapper.queryArticle();
//			//查询所有信息列表
//			List<String> artTimeList = articleMapper.queryGroupByArticleTime();
//			if(!CollectionUtils.isEmpty(artTimeList)){
//				for (String artTime : artTimeList) {
//					if(!CollectionUtils.isEmpty(list)){
//						//每一天的所有信息列表
//						List<Article> resultList = new ArrayList<Article>();
//						for (Article article : list) {
//							String queryTime = DateUtil.date2Str2(article.getArticleTime());
//							if(StringUtils.equals(artTime, queryTime)){
//								resultList.add(article);
//							}
//						}
//						everyDayMap.put(artTime, resultList);
//					}
//				}
//			}
//			dataMap.put("articleList", everyDayMap);
//		}else if(StringUtils.equalsIgnoreCase(day, CommonConstant.NOW)){  
//			//查询当天
//			dataMap.put("articleList", articleMapper.queryNowDayArticle());
//		}else{
//			logger.warn("day参数：{}，传入错误", day);
//			throw new ScException("参数有误");
//		}
		return dataMap;
	}

	
	@Override
	public List<String> queryArticleContent(Integer id, String queryTime) {
		List<String> articleContentList = null ;
//		if(StringUtils.isNoneBlank(queryTime)){
//			//查询一天所有的记录
//			articleContentList = articleMapper.queryArticleContentsByArticleTime(queryTime);
//		}else{
//			//查询具体的一条记录
//			articleContentList = articleMapper.queryArticleContentById(id);
//		}
		return articleContentList;
	}
	
	
}
