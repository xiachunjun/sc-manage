package com.sc.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.ScException;
import com.sc.common.util.EncryptUtil;
import com.sc.common.util.ListUtils;
import com.sc.dao.UserMapper;
import com.sc.domain.User;
import com.sc.model.request.UserModel;
import com.sc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	
	@Transactional
	@Override
	public void register(UserModel userModel) {
		//先查询注册用户名是否存在
		User user = userMapper.selectUserLoginNameIsExist(userModel.getUserLoginName());
		if(user == null){
			//用户注册
			User record = setUserProperty(userModel);
			int flag = userMapper.insert(record);
			if(flag != 1){
				throw new ScException("注册用户出错");
			}
		}else{
			if(user.getDataState() == 0){
				throw new ScException("该用户名已被注册，请重新设置");
			}
			if(user.getDataState() == 1){
				throw new ScException("该用户名已存在");
			}
		}
	}


	@Override
	public void login(UserModel userModel, HttpServletRequest request) {
		User loginUser = userMapper.selectUserByLoginName(userModel.getUserLoginName());
		if(loginUser == null){
			throw new ScException("对不起! 该登录用户名不存在");
		}
		if(!EncryptUtil.match(userModel.getUserLoginPwd(), loginUser.getUserLoginPwd())){
			throw new ScException("对不起! 密码错误，请重新输入");
		}
		request.getSession().setAttribute(CommonConstant.USER_LOGIN_NAME, loginUser.getUserLoginName());
	}
	
	
	@Override
	public Map<String, Object> queryUsertList() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<User> list = userMapper.selectUserList();
		dataMap.put("userList", list);
		return dataMap;
	}
	
	
	/**********************以下为私有方法**********************/
	
	private User setUserProperty(UserModel userModel) {
		User record = new User();
		BeanUtils.copyProperties(userModel, record);
		//设置userCode
		Integer maxCode = userMapper.getMaxCode();
		if(null == maxCode){
			record.setUserCode(CommonConstant.FIRST_CODE);
		}else{
			record.setUserCode(ListUtils.addZero2Str(maxCode+1, 8));
		}
		//对密码进行PasswordEncoder加密（相同的密码，每次生成的结果都不一样）
		record.setUserLoginPwd(EncryptUtil.encrypt(userModel.getUserLoginPwd()));
		record.setId(null);
		record.setDataState(1);
		record.setDataVersion(1);
		record.setCreateUser("SYS");
		record.setUpdateUser("SYS");
		record.setCreateTime(new Date());
		record.setUpdateTime(record.getCreateTime());
		return record;
	}
	
	
	
}
