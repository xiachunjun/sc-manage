package com.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.common.constant.ScException;
import com.sc.dao.RoleResourceRelMapper;
import com.sc.domain.Resource;
import com.sc.domain.RoleResourceRel;
import com.sc.service.IRoleResourceRelService;
import com.sc.support.AuthUser;
import com.sc.support.UserContext;

@Service
public class RoleResourceRelServiceImpl implements IRoleResourceRelService {

	@Autowired
	private RoleResourceRelMapper roleResourceRelMapper;
	
	
	@Transactional
	@Override
	public void setResource2Role(String roleCode, String resourceCode) {
		AuthUser authUser = UserContext.getAuthUser();
		RoleResourceRel record = new RoleResourceRel();
		record.setId(null);
		record.setRelRoleCode(roleCode);
		record.setRelResCode(resourceCode);
		record.setDataMemo(null);
		record.setDataState(1);
		record.setDataVersion(1);
		record.setCreateTime(new Date());
		record.setCreateUser(authUser.getUserLoginName());
		record.setUpdateTime(record.getCreateTime());
		record.setUpdateUser(record.getUpdateUser());
		int result = roleResourceRelMapper.saveRoleResourceRel(record);
		if(result != 1){
			throw new ScException("给角色赋予资源权限出错");
		}
	}

	
	@Override
	public List<Resource> queryResourceListByUserCode(String userCode) {
		List<Resource> list = roleResourceRelMapper.queryResourceListByUserCode(userCode);
		return list;
	}
	
	
}
