package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.Role;

public interface RoleMapper {

	@Insert({
		"insert into sc_roles(",
			"role_code, role_name, data_memo, data_state, data_version, create_user, update_user, create_time, update_time) ",
		"values(",
			"#{roleCode,jdbcType=VARCHAR}, #{roleName,jdbcType=VARCHAR}, ",
			"#{dataMemo,jdbcType=VARCHAR}, ",
			"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int saveRole(Role record);
	
	
	@Select({
		"select id, role_code, role_name, data_memo, data_state ",
		"from sc_roles ",
		"where data_state = 1"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="role_code", property="roleCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<Role> queryRoleList();
	
	
	@Select({
		"select id, role_code, role_name, data_memo, data_state ",
		"from sc_roles ",
		"where data_state=1 and id=#{id,jdbcType=INTEGER}"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="role_code", property="roleCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	Role queryRoleById(Integer id);
	
	
	@Delete({
		"delete from sc_roles where id=#{id,jdbcType=INTEGER}"
	})
	int deleteRoleById(Integer id);
	
	
	@Update({
		"update sc_roles set ",
		"role_name=#{roleName,jdbcType=VARCHAR}, update_time=now() ",
		"where id=#{id,jdbcType=INTEGER}"
	})
	int updateRoleById(Role record);
	
	
}
