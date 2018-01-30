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
import com.sc.domain.ArticleDomain;
import com.sc.model.request.ArticleModel;
import com.sc.service.IArticleService;
import com.sc.support.UserContext;

//@Service
public class ArticleServiceImpl implements IArticleService {

	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);	
	
//	@Autowired
	private ArticleMapper articleMapper;
	
	
	@Transactional
	@Override
	public void saveArticle(ArticleModel articleModel) {
		ArticleDomain articleDomain = new ArticleDomain();
		BeanUtils.copyProperties(articleModel, articleDomain);
		articleDomain.setArticleTime(DateUtil.str2Date(articleModel.getArtTime()));
		articleDomain.setLinkUserCheckState(0);  //联系人审核状态（0-初始，1-通过，2-拒绝）
		articleDomain.setSignUserCheckState("0"); //签发状态（0-初始，1-通过，2-拒绝）
		articleDomain.setId(null);
		articleDomain.setDataState(1);
		articleDomain.setDataVersion(1);
		articleDomain.setCreateUser(UserContext.getLoginName());
		articleDomain.setUpdateUser(articleDomain.getCreateUser());
		articleDomain.setCreateTime(new Date());
		articleDomain.setUpdateTime(articleDomain.getCreateTime());
		int flag = articleMapper.insertSelective(articleDomain);
		if (flag != 1) {
			throw new ScException("保存每日信息出错");
		}
	}

	
	@Override
	public Map<String, Object> queryNotAuditArticle(String userLoginName) {
		//TODO 院办公室可见，审批流上的领导可见, 如果登录用户是院办公室人，也可以查询到
		Map<String, Object> dataMap = new HashMap<String, Object>();
		ArticleDomain record = new ArticleDomain();
		record.setLinkUserCheckState(0);  //查询待处理的数据
		record.setDataState(1);
		List<ArticleDomain> list = articleMapper.select(record);
		dataMap.put("articleList", list);
		return dataMap;
	}
	
	
	@Transactional
	@Override
	public void auditArticle(Integer id, String signUserCheckState) {
		ArticleDomain article = articleMapper.selectByPrimaryKey(id);
		if(null != article){
			//TODO 查看登录人是否是签发人
			String loginName = UserContext.getLoginName();
			if(StringUtils.equals(loginName, article.getArticleSignUser())){
				ArticleDomain record = new ArticleDomain();
				record.setId(id);
				record.setSignUserCheckState(signUserCheckState);
				record.setUpdateUser(loginName);
				record.setUpdateTime(new Date());
				int flag = articleMapper.updateByPrimaryKeySelective(record);
				if(flag != 1){
					throw new ScException("签发信息出错");
				}
			}
		}
	}
	

	@Override
	public Map<String, Object> queryAllArticle(String day) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(StringUtils.equalsIgnoreCase(day, CommonConstant.ALL)){
			//每一天的所有信息的map
			Map<String, List<ArticleDomain>> everyDayMap = new LinkedHashMap<String, List<ArticleDomain>>();
			//按天分组，查询所有天数
			ArticleDomain record = new ArticleDomain();
			record.setDataState(1);
			//TODO 查询审批全部通过的，  可以直接按时间分组
			List<ArticleDomain> list = articleMapper.select(record);
			
			//TODO 查询所有审批全部通过的信息列表的日期 
			List<String> artTimeList = articleMapper.queryGroupByArticleTime();
			if(!CollectionUtils.isEmpty(artTimeList)){
				for (String artTime : artTimeList) {
					if(!CollectionUtils.isEmpty(list)){
						//每一天的所有信息列表
						List<ArticleDomain> resultList = new ArrayList<ArticleDomain>();
						for (ArticleDomain article : list) {
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
			//TODO 查询当天并且审核通过的？
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
			//TODO 审核通过   查询一天所有的记录
			articleContentList = articleMapper.queryArticleContentsByArticleTime(queryTime);
		}else{
			//TODO 审核通过   查询具体的一条记录
			articleContentList = articleMapper.queryArticleContentById(id);
		}
		return articleContentList;
	}
	
	
}
