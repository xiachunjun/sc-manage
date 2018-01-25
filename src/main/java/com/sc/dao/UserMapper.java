package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sc.common.mapper.MyMapper;
import com.sc.domain.UserDomain;

public interface UserMapper extends MyMapper<UserDomain>{

	@Select({
		"select distinct ",
		   "a.id, a.user_login_name as userLoginName, a.user_name as userName ",
		"from sc_users a ",
		"left join sc_user_posi_rel b on b.ref_user_id=a.id ",
		"left join sc_positions c on c.id=b.ref_posi_id ",
		"where c.ref_dept_id=#{deptId,jdbcType=INTEGER}"
	})
	List<UserDomain> queryUserListByDeptId(@Param("deptId")Integer deptId);

	
}