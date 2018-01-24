package com.sc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.common.constant.ScException;
import com.sc.common.util.EncryptUtil;
import com.sc.dao.UserMapper;
import com.sc.domain.UserDomain;
import com.sc.model.request.UpdateUserPwdModel;
import com.sc.model.request.UserModel;
import com.sc.service.IUserService;
import com.sc.support.UserContext;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	
	@Transactional
	@Override
	public void saveUser(UserModel userModel) {
		UserDomain record = new UserDomain();
		record.setUserLoginName(userModel.getUserLoginName());
		UserDomain userDomain = userMapper.selectOne(record);
		if (userDomain == null) {
			userDomain = new UserDomain();
			BeanUtils.copyProperties(userModel, userDomain);
			int flag = userMapper.insertSelective(userDomain);
			if (flag != 1) {
				throw new ScException("添加用户出错");
			}
		} else {
			throw new ScException("该用户名已存在，请重新设置");
		}
	}
	

	@Override
	public UserDomain login(UserModel userModel) {
		UserDomain record = new UserDomain();
		record.setUserLoginName(userModel.getUserLoginName());
		UserDomain loginUser = userMapper.selectOne(record);
		if (loginUser == null) {
			throw new ScException("用户名不存在");
		}
		if (loginUser.getDataState() != 1) {
			throw new ScException("用户名状态异常");
		}
		if (!EncryptUtil.match(userModel.getUserLoginPwd(), loginUser.getUserLoginPwd())) {
			throw new ScException("密码错误，请重新输入");
		}
		return loginUser;
	}
	

	@Override
	public List<UserDomain> queryUsertList() {
		UserDomain record = new UserDomain();
		record.setDataState(1);
		return userMapper.select(record);
	}

	
	@Transactional
	@Override
	public void updatePwd(UpdateUserPwdModel updateUserPwdModel) {
		UserDomain record = new UserDomain();
		record.setId(updateUserPwdModel.getId());
		record.setUserLoginPwd(EncryptUtil.encrypt(updateUserPwdModel.getUserLoginPwd()));
		record.setUpdateTime(new Date());
		record.setUpdateUser(UserContext.getLoginName());
		int result = userMapper.updateByPrimaryKeySelective(record);
		if (result != 1) {
			throw new ScException("修改密码异常");
		}
	}

	
	@Override
	public List<UserDomain> queryByDept(String deptCode) {
		return null;
	}


}
