package com.sc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sc.common.mapper.MyMapper;
import com.sc.domain.UserDomain;
import com.sc.model.response.UserInfoResult;

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

	
	@Select({
		"select ", 
			"a.id as userId, a.user_name as userName, ", 
			"c.id as posiId, c.posi_name as posiName, ", 
			"d.id as deptId, d.dept_name as deptName ", 
		"from sc_users a ", 
		"left join sc_user_posi_rel b on b.ref_user_id=a.id ", 
		"left join sc_positions c on c.id=b.ref_posi_id ", 
		"left join sc_departments d on d.id=c.ref_dept_id ", 
		"where a.id=#{id,jdbcType=INTEGER}"		
	})
	UserInfoResult queryUserInfoByUserId(Integer id);

	
}