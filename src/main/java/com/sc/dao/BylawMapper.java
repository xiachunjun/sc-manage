package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.sc.dao.provider.BylawSqlProvider;
import com.sc.domain.Bylaw;

public interface BylawMapper {

	@Insert({
		"insert into sc_bylaws(",
			"bylaws_code, bylaws_category, bylaws_name, bylaws_no, article_no, article_time, ",
			"bylaws_content, file_url, data_state, data_version, create_user, update_user, create_time, update_time) ",
		"values(",
			"#{bylawsCode,jdbcType=VARCHAR}, #{bylawsCategory,jdbcType=VARCHAR}, ",
			"#{bylawsName,jdbcType=VARCHAR}, #{bylawsNo,jdbcType=VARCHAR}, #{articleNo,jdbcType=VARCHAR}, ",
			"#{articleTime,jdbcType=TIMESTAMP}, #{bylawsContent,jdbcType=VARCHAR}, #{fileUrl,jdbcType=VARCHAR}, ",
			"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int saveBylaw(Bylaw record);
	
	
	@Select({
		"select id, bylaws_code, bylaws_category, bylaws_name, bylaws_no, article_no, ",
			"article_time, bylaws_content, file_url, data_state ",
		"from sc_bylaws ",
		"where data_state = 1"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="bylaws_code", property="bylawsCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="bylaws_category", property="bylawsCategory", jdbcType=JdbcType.VARCHAR),
	    @Result(column="bylaws_name", property="bylawsName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="bylaws_no", property="bylawsNo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="article_no", property="articleNo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="article_time", property="articleTime", jdbcType=JdbcType.TIMESTAMP),
	    @Result(column="bylaws_content", property="bylawsContent", jdbcType=JdbcType.VARCHAR),
	    @Result(column="file_url", property="fileUrl", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER),
	    @Result(column="data_version", property="dataVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
	})
	List<Bylaw> queryBylaw();

	
	@UpdateProvider(type=BylawSqlProvider.class, method="updateBylaw")  
	int updateBylaw(Bylaw record);

	
	@Update({
		"update sc_bylaws set ",
			"data_state=0,",
			"update_user=#{updateUser,jdbcType=VARCHAR},",
			"update_time=now() ",
		"where id=#{id,jdbcType=INTEGER}"
	})
	int updateStatus(@Param("id")Integer bylawsId, @Param("updateUser")String userName);


	@Select({
		"select file_url from sc_bylaws where id = #{id, jdbcType=INTEGER}"
	})
	String queryFileUrlById(@Param("id")Integer bylawsId);
	
	
	
}
