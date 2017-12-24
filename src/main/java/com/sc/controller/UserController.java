package com.sc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ScException;
import com.sc.common.constant.ResponseEnum;
import com.sc.model.request.UserModel;
import com.sc.service.IUserService;

/**
 * 用户注册+登录+退出
 *
 */
@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);	
	
	@Autowired
	private IUserService userService;
	
	
	/**
	 * 注册用户
	 * @param userModel
	 * @return
	 */
	@RequestMapping(value = "/user/register", method = {RequestMethod.POST})
	public DataResponse register(UserModel userModel){
		DataResponse dr = null;
		try {
			userService.register(userModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("注册用户异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 用户登录
	 * @param userModel
	 * @return
	 */
	@RequestMapping(value = "/user/login", method = {RequestMethod.POST})
	public DataResponse login(UserModel userModel, HttpServletRequest request){
		DataResponse dr = null;
		try {
			userService.login(userModel, request);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("用户登录异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/**
	 * 用户退出
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/user/logout", method = {RequestMethod.POST})
	public DataResponse logout(HttpServletRequest request){
		request.getSession().removeAttribute(CommonConstant.USER_LOGIN_NAME);
		return new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
	}
	
	
	/**
	 * 查询用户列表
	 * @return
	 */
	@RequestMapping(value = "/user/query/list", method = {RequestMethod.POST})
	public DataResponse queryUsertList(){
		DataResponse dr = null;
		try {
			Map<String, Object> dataMap = userService.queryUsertList();
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.setDataMap(dataMap);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询用户列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	
}
