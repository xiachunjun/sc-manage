package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.Article;

public interface ArticleMapper {

	@Insert({
		"insert into sc_articles(",
			"article_link_user, article_link_user_phone, article_sign_user, secrecy_level, article_time, article_title, article_content, ",
			"data_state, data_version, create_user, update_user, create_time, update_time) ",
		"values(",
			"#{articleLinkUser,jdbcType=VARCHAR}, #{articleLinkUserPhone,jdbcType=VARCHAR}, #{articleSignUser,jdbcType=VARCHAR}, ",
			"#{secrecyLevel,jdbcType=VARCHAR}, #{articleTime,jdbcType=TIMESTAMP}, ",
			"#{articleTitle,jdbcType=VARCHAR}, #{articleContent,jdbcType=VARCHAR}, ",
			"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int saveArticle(Article record);
	
	
	@Select({
		"select id, article_link_user, article_link_user_phone, article_sign_user, secrecy_level, ",
		 	"article_time, article_title, article_content, data_state ",
		"from sc_articles ",
		"where data_state = 1 ",
		"order by article_time desc"
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="article_link_user", property="articleLinkUser", jdbcType=JdbcType.VARCHAR),
	    @Result(column="article_link_user_phone", property="articleLinkUserPhone", jdbcType=JdbcType.VARCHAR),
	    @Result(column="article_sign_user", property="articleSignUser", jdbcType=JdbcType.VARCHAR),
	    @Result(column="secrecy_level", property="secrecyLevel", jdbcType=JdbcType.VARCHAR),
	    @Result(column="article_time", property="articleTime", jdbcType=JdbcType.TIMESTAMP),
	    @Result(column="article_title", property="articleTitle", jdbcType=JdbcType.VARCHAR),
	    @Result(column="article_content", property="articleContent", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Article> queryArticle();
	
	
	@Select({
		"select id, article_link_user, article_link_user_phone, article_sign_user, secrecy_level, ",
		 	"article_time, article_title, article_content, data_state ",
		"from sc_articles ",
		"where data_state = 1 and to_days(article_time) = to_days(now()) ",
		"order by article_time desc"
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="article_link_user", property="articleLinkUser", jdbcType=JdbcType.VARCHAR),
	    @Result(column="article_link_user_phone", property="articleLinkUserPhone", jdbcType=JdbcType.VARCHAR),
	    @Result(column="article_sign_user", property="articleSignUser", jdbcType=JdbcType.VARCHAR),
	    @Result(column="secrecy_level", property="secrecyLevel", jdbcType=JdbcType.VARCHAR),
	    @Result(column="article_time", property="articleTime", jdbcType=JdbcType.TIMESTAMP),
	    @Result(column="article_title", property="articleTitle", jdbcType=JdbcType.VARCHAR),
	    @Result(column="article_content", property="articleContent", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Article> queryNowDayArticle();


	@Select({
		"select date_format(article_time,'%Y-%m-%d')",
		"from sc_articles ",
		"where data_state = 1 ",
		"group by date_format(article_time,'%Y-%m-%d') ",
		"order by article_time desc"
	})
	List<String> queryGroupByArticleTime();

	
	@Select({
		"select article_content from sc_articles ",
		"where data_state = 1 ",
		"and date_format(article_time,'%Y-%m-%d')=#{queryTime,jdbcType=VARCHAR}"
	})
	List<String> queryArticleContentsByArticleTime(@Param("queryTime")String queryTime);


	@Select({
		"select article_content from sc_articles ",
		"where data_state = 1 ",
		"and id=#{id,jdbcType=INTEGER}"
	})
	List<String> queryArticleContentById(Integer id);
	
	
	
	
	
	
}
