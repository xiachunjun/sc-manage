package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.BylawDomain;
import com.sc.model.response.BylawCountGroupByCategory;

public interface BylawMapper {
    @Delete({
        "delete from sc_bylaws",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sc_bylaws (id, bylaws_name, ",
        "bylaws_no, article_no, ",
        "article_time, file_url, ",
        "bylaws_category, data_state, ",
        "data_version, create_user, ",
        "update_user, create_time, ",
        "update_time, bylaws_content)",
        "values (#{id,jdbcType=INTEGER}, #{bylawsName,jdbcType=VARCHAR}, ",
        "#{bylawsNo,jdbcType=VARCHAR}, #{articleNo,jdbcType=VARCHAR}, ",
        "#{articleTime,jdbcType=TIMESTAMP}, #{fileUrl,jdbcType=VARCHAR}, ",
        "#{bylawsCategory,jdbcType=VARCHAR}, #{dataState,jdbcType=INTEGER}, ",
        "#{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{bylawsContent,jdbcType=LONGVARCHAR})"
    })
    int insert(BylawDomain record);

    @Select({
        "select",
        "id, bylaws_name, bylaws_no, article_no, article_time, file_url, bylaws_category, ",
        "data_state, data_version, create_user, update_user, create_time, update_time, ",
        "bylaws_content",
        "from sc_bylaws",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bylaws_name", property="bylawsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bylaws_no", property="bylawsNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_no", property="articleNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_time", property="articleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="file_url", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="bylaws_category", property="bylawsCategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bylaws_content", property="bylawsContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    BylawDomain selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, bylaws_name, bylaws_no, article_no, article_time, file_url, bylaws_category, ",
        "data_state, data_version, create_user, update_user, create_time, update_time, ",
        "bylaws_content",
        "from sc_bylaws"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bylaws_name", property="bylawsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bylaws_no", property="bylawsNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_no", property="articleNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_time", property="articleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="file_url", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="bylaws_category", property="bylawsCategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
        @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bylaws_content", property="bylawsContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<BylawDomain> selectAll();

    @Update({
        "update sc_bylaws",
        "set bylaws_name = #{bylawsName,jdbcType=VARCHAR},",
          "bylaws_no = #{bylawsNo,jdbcType=VARCHAR},",
          "article_no = #{articleNo,jdbcType=VARCHAR},",
          "article_time = #{articleTime,jdbcType=TIMESTAMP},",
          "file_url = #{fileUrl,jdbcType=VARCHAR},",
          "bylaws_category = #{bylawsCategory,jdbcType=VARCHAR},",
          "data_state = #{dataState,jdbcType=INTEGER},",
          "data_version = #{dataVersion,jdbcType=INTEGER},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "bylaws_content = #{bylawsContent,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BylawDomain record);
    
    @Update({
        "update sc_bylaws  set data_state= #{dataState,jdbcType=INTEGER} ",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateState(@Param("id")Integer id,@Param("dataState")Integer dataState);
    
    
    
    @Select({
		"select bylaws_category as bylawsCategory, count(1) as count from sc_bylaws ",
		"where data_state = 1 ",
		"group by bylaws_category"
	})
	List<BylawCountGroupByCategory> queryCountGroupBylawCategory();
}