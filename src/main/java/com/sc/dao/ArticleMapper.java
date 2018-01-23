package com.sc.dao;

import com.sc.domain.ArticleDomain;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ArticleMapper {
    @Delete({
        "delete from sc_articles",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sc_articles (id, article_link_user, ",
        "link_user_check_state, article_link_user_phone, ",
        "article_sign_user, sign_user_check_state, ",
        "secrecy_level, article_time, ",
        "article_title, data_state, ",
        "data_version, create_user, ",
        "update_user, create_time, ",
        "update_time, article_content)",
        "values (#{id,jdbcType=INTEGER}, #{articleLinkUser,jdbcType=VARCHAR}, ",
        "#{linkUserCheckState,jdbcType=INTEGER}, #{articleLinkUserPhone,jdbcType=VARCHAR}, ",
        "#{articleSignUser,jdbcType=VARCHAR}, #{signUserCheckState,jdbcType=VARCHAR}, ",
        "#{secrecyLevel,jdbcType=VARCHAR}, #{articleTime,jdbcType=TIMESTAMP}, ",
        "#{articleTitle,jdbcType=VARCHAR}, #{dataState,jdbcType=INTEGER}, ",
        "#{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{articleContent,jdbcType=LONGVARCHAR})"
    })
    int insert(ArticleDomain record);

    @Select({
        "select",
        "id, article_link_user, link_user_check_state, article_link_user_phone, article_sign_user, ",
        "sign_user_check_state, secrecy_level, article_time, article_title, data_state, ",
        "data_version, create_user, update_user, create_time, update_time, article_content",
        "from sc_articles",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="article_link_user", property="articleLinkUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="link_user_check_state", property="linkUserCheckState", jdbcType=JdbcType.INTEGER),
        @Result(column="article_link_user_phone", property="articleLinkUserPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_sign_user", property="articleSignUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_user_check_state", property="signUserCheckState", jdbcType=JdbcType.VARCHAR),
        @Result(column="secrecy_level", property="secrecyLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_time", property="articleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="article_title", property="articleTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="article_content", property="articleContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    ArticleDomain selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, article_link_user, link_user_check_state, article_link_user_phone, article_sign_user, ",
        "sign_user_check_state, secrecy_level, article_time, article_title, data_state, ",
        "data_version, create_user, update_user, create_time, update_time, article_content",
        "from sc_articles"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="article_link_user", property="articleLinkUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="link_user_check_state", property="linkUserCheckState", jdbcType=JdbcType.INTEGER),
        @Result(column="article_link_user_phone", property="articleLinkUserPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_sign_user", property="articleSignUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_user_check_state", property="signUserCheckState", jdbcType=JdbcType.VARCHAR),
        @Result(column="secrecy_level", property="secrecyLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_time", property="articleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="article_title", property="articleTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="article_content", property="articleContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ArticleDomain> selectAll();

    @Update({
        "update sc_articles",
        "set article_link_user = #{articleLinkUser,jdbcType=VARCHAR},",
          "link_user_check_state = #{linkUserCheckState,jdbcType=INTEGER},",
          "article_link_user_phone = #{articleLinkUserPhone,jdbcType=VARCHAR},",
          "article_sign_user = #{articleSignUser,jdbcType=VARCHAR},",
          "sign_user_check_state = #{signUserCheckState,jdbcType=VARCHAR},",
          "secrecy_level = #{secrecyLevel,jdbcType=VARCHAR},",
          "article_time = #{articleTime,jdbcType=TIMESTAMP},",
          "article_title = #{articleTitle,jdbcType=VARCHAR},",
          "data_state = #{dataState,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "article_content = #{articleContent,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ArticleDomain record);
}