package com.sc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.model.request.ArticleModel;
import com.sc.service.IArticleService;
import com.sc.support.UserContext;

/**
 * 每日信息
 * 
 */
@Controller
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);	
	
	@Autowired
	private IArticleService articleService;
	
	@RequestMapping("/article/articleList")
	public String articleList() {
		return "/articleList";
	}
	
	/**
	 * 编制信息  （院办公室人员发起，开放给院办公室）
	 */
	@RequestMapping(value = "/article/save", method = {RequestMethod.POST})
	@ResponseBody
	public DataResponse saveArticle(ArticleModel articleModel, HttpServletRequest request){
		DataResponse dr = null;
//		try {
//			articleModel.setUserCode(UserContext.getUserCode());
//			articleService.saveArticle(articleModel);
//			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
//		} catch (ScException e) {
//			logger.error(e.getMessage());
//			dr = new DataResponse(e);
//		} catch (Exception e) {
//			logger.error("保存编制信息异常", e);
//			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
//		}
		return dr;
	}
	
	
	/**
	 * 查询待审批信息 （院办公室可见，审批流上的领导可见，未审批完成的信息显示在这里）
	 */
	@RequestMapping(value = "/article/query/notAudit", method = {RequestMethod.POST})
	@ResponseBody
	public DataResponse queryNotAuditArticle(HttpServletRequest request){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = articleService.queryNotAuditArticle(UserContext.getLoginName());
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询待审批信息异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 签发
	 */
	@RequestMapping(value = "/article/audit", method = {RequestMethod.POST})
	@ResponseBody
	public DataResponse auditArticle(@RequestParam(value="id", required=true)Integer id, 
			HttpServletRequest request){
		DataResponse dr = null;
		try {
			articleService.auditArticle(id, UserContext.getLoginName());
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("签发信息异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 下载
	 */
	@RequestMapping(value = "/article/download", method = { RequestMethod.POST })
	public void downloadFile(@RequestParam(name = "id", required = true) Integer id,
			HttpServletRequest request, HttpServletResponse response) {
		//把信息内容下载到文件中
		
	}
	
	
	/**
	 * 查询‘每日信息’列表
	 * 当参数day为all时，表示查询所有天数信息列表； 当为now时，表示查询当天信息列表
	 */
	@RequestMapping(value = "/article/query/allday", method = {RequestMethod.POST})
	@ResponseBody
	public DataResponse queryAllArticle(@RequestParam(name="day", required=true, defaultValue="now")String day){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = articleService.queryAllArticle(day);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询每日信息列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 查询内容详情
	 * 
	 * 请求参数有id, 说明请求的是具体一条记录内容
	 * 请求参数有queryTime, 说明请求的是具体那一天所有记录内容, 格式：yyyy-MM-dd
	 */
	@RequestMapping(value = "/article/query/content", method = {RequestMethod.POST})
	@ResponseBody
	public DataResponse queryArticleContent(Integer id, String queryTime){
		DataResponse dr = null;
		try {
			if(id == null && !StringUtils.isNoneBlank(queryTime)){
				dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
				dr.put(CommonConstant.FAILED_MSG, "参数不能为空！");
				return dr;
			}
			List<String> list = articleService.queryArticleContent(id, queryTime);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("articleContents", list);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("点击查看具体信息列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	
}
