package com.sc.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sc.common.mapper.MyMapper;
import com.sc.domain.UserDomain;
import com.sc.domain.UserPosiRelDomain;

public interface UserPosiRelMapper extends MyMapper<UserPosiRelDomain>{
   
	@Select({
"select su.id as id,su.user_name as user_name from sc_user_posi_rel supr,sc_users su   where supr.data_state=1 "
+ "and supr.ref_posi_id=#{posiId,jdbcType=INTEGER} and supr.ref_user_id=su.id order by supr.id limit 0,1"
	})
	@Results({
	    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
	    @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
	})
	UserDomain queryUserByPosiId(@Param("posiId")Integer posiId);
}