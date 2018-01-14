package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sc.domain.Role;
import com.sc.domain.UserRoleRel;

public interface UserRoleRelMapper {

	@Insert({
		"insert into sc_user_role_rel(",
			"rel_user_code, rel_role_code, data_memo, data_state, data_version, create_user, update_user, create_time, update_time) ",
		"values(",
			"#{relUserCode,jdbcType=VARCHAR}, #{relRoleCode,jdbcType=VARCHAR}, ",
			"#{dataMemo,jdbcType=VARCHAR}, ",
			"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int saveUserRoleRel(UserRoleRel record);
	
	
	@Select({
		"select id, rel_user_code, rel_role_code, data_memo, data_state ",
		"from sc_user_role_rel ",
		"where data_state = 1"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="rel_user_code", property="relUserCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="rel_role_code", property="relRoleCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<UserRoleRel> queryUserRoleRelList();
	
	
	@Select({
		"select id, rel_user_code, rel_role_code, data_memo, data_state ",
		"from sc_user_role_rel ",
		"where data_state=1 and id=#{id,jdbcType=INTEGER}"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="rel_user_code", property="relUserCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="rel_role_code", property="relRoleCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	UserRoleRel queryUserRoleRelById(Integer id);
	
	
	@Delete({
		"delete from sc_user_role_rel where id=#{id,jdbcType=INTEGER}"
	})
	int deleteUserRoleRelById(Integer id);


	@Select({
		"select b.role_code as roleCode, b.role_name as roleName ",
		"from sc_user_role_rel a ",
		"left join sc_roles b on a.rel_role_code=b.role_code ",
		"where a.data_state=1 and a.rel_user_code=#{userCode,jdbcType=VARCHAR}"
	})
	Role queryUserRoleByUserCode(@Param("userCode")String userCode);
	
	
	
}
