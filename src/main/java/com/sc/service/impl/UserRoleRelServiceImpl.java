//package com.sc.service.impl;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.sc.common.constant.ScException;
//import com.sc.dao.UserRoleRelMapper;
//import com.sc.domain.Role;
//import com.sc.domain.UserRoleRel;
//import com.sc.service.IUserRoleRelService;
//import com.sc.support.AuthUser;
//import com.sc.support.UserContext;
//
//@Service
//public class UserRoleRelServiceImpl implements IUserRoleRelService {
//
//	@Autowired
//	private UserRoleRelMapper userRoleRelMapper;
//	
//	
//	@Transactional
//	@Override
//	public void setRole2User(String userCode, String roleCode) {
//		AuthUser authUser = UserContext.getAuthUser();
//		UserRoleRel record = new UserRoleRel();
//		record.setId(null);
//		record.setRelRoleCode(roleCode);
//		record.setRelUserCode(userCode);
//		record.setDataMemo(null);
//		record.setDataState(1);
//		record.setDataVersion(1);
//		record.setCreateTime(new Date());
//		record.setCreateUser(authUser.getUserLoginName());
//		record.setUpdateTime(record.getCreateTime());
//		record.setUpdateUser(record.getUpdateUser());
//		int result = userRoleRelMapper.saveUserRoleRel(record);
//		if(result != 1){
//			throw new ScException("设置用户角色失败");
//		}
//	}
//
//	
//	@Override
//	public Role queryUserRoleByUserCode(String userCode) {
//		Role role = userRoleRelMapper.queryUserRoleByUserCode(userCode);
//		return role;
//	}
//	
//	
//	
//}
