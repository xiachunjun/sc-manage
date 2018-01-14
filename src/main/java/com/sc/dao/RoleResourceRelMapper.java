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

import com.sc.domain.Resource;
import com.sc.domain.RoleResourceRel;

public interface RoleResourceRelMapper {

	@Insert({
		"insert into sc_role_resource_rel(",
			"rel_role_code, rel_res_code, data_memo, data_state, data_version, create_user, update_user, create_time, update_time) ",
		"values(",
			"#{relRoleCode,jdbcType=VARCHAR}, #{relResCode,jdbcType=VARCHAR}, ",
			"#{dataMemo,jdbcType=VARCHAR}, ",
			"#{dataState,jdbcType=INTEGER}, #{dataVersion,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateUser,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int saveRoleResourceRel(RoleResourceRel record);
	
	
	@Select({
		"select id, rel_role_code, rel_res_code, data_memo, data_state ",
		"from sc_role_resource_rel ",
		"where data_state = 1"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="rel_role_code", property="relRoleCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="rel_res_code", property="relResCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	List<RoleResourceRel> queryRoleResourceRelList();
	
	
	@Select({
		"select id, rel_role_code, rel_res_code, data_memo, data_state ",
		"from sc_role_resource_rel ",
		"where data_state=1 and id=#{id,jdbcType=INTEGER}"	
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
	    @Result(column="rel_role_code", property="relRoleCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="rel_res_code", property="relResCode", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_memo", property="dataMemo", jdbcType=JdbcType.VARCHAR),
	    @Result(column="data_state", property="dataState", jdbcType=JdbcType.INTEGER)
	})
	RoleResourceRel queryRoleResourceRelById(Integer id);
	
	
	@Delete({
		"delete from sc_role_resource_rel where id=#{id,jdbcType=INTEGER}"
	})
	int deleteRoleResourceRelById(Integer id);


	@Select({
		"select a.res_code as resCode, a.res_name as resName, ",
			"a.res_url as resUrl, a.res_type as resType, a.res_level as resLevel ",
		"from sc_resources a ",
		"left join sc_role_resource_rel b on b.rel_res_code=a.res_code ",
		"left join sc_user_role_rel c on c.rel_role_code=b.rel_role_code ",
		"where c.data_state=1 and c.rel_user_code=#{userCode,jdbcType=VARCHAR}"
	})
	List<Resource> queryResourceListByUserCode(@Param("userCode")String userCode);
	
	
}
