package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.Resource;

public interface ResourceMapper {

	@Insert({
		"insert into sc_resources(",
			"res_code, res_name, res_url, res_type, res_level,",
			"data_memo, data_state, data_version, create_user, update_user, create_time, update_time) ",
		"values(",
			"#{resCode,jdbcType=VARCHAR}, #{resName,jdbcType=VARCHAR}, #{resUrl,jdbcType=VARCHAR},",
			"#{resType,jdbcType=INTEGER}, #{resLevel,jdbcType=INTEGER}, #{dataMemo,jdbcType=VARCHAR}, ",
			"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int saveResource(Resource record);
	
	
	@Select({
		"select id, res_code, res_name, res_url, res_type, res_level, data_memo, data_state ",
		"from sc_resources ",
		"where data_state = 1"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="res_code", property="resCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="res_name", property="resName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="res_url", property="resUrl", jdbcType=JdbcType.VARCHAR),
	    @Result(column="res_type", property="resType", jdbcType=JdbcType.INTEGER),
	    @Result(column="res_level", property="resLevel", jdbcType=JdbcType.INTEGER),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Resource> queryResourceList();
	
	
	@Select({
		"select id, res_code, res_name, res_url, res_type, res_level, data_memo, data_state ",
		"from sc_resources ",
		"where data_state=1 and id=#{id,jdbcType=INTEGER}"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="res_code", property="resCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="res_name", property="resName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="res_url", property="resUrl", jdbcType=JdbcType.VARCHAR),
	    @Result(column="res_type", property="resType", jdbcType=JdbcType.INTEGER),
	    @Result(column="res_level", property="resLevel", jdbcType=JdbcType.INTEGER),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	Resource queryResourceById(Integer id);
	
	
	@Delete({
		"delete from sc_resources where id=#{id,jdbcType=INTEGER}"
	})
	int deleteResourceById(Integer id);
	
	
}
