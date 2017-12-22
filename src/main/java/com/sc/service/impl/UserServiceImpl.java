package com.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dao.UserMapper;
import com.sc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	//private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	
	
	
}
