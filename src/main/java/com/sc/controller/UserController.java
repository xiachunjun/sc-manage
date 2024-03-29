package com.sc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sc.common.constant.CommonConstant;
import com.sc.common.constant.DataResponse;
import com.sc.common.constant.ResponseEnum;
import com.sc.common.constant.ScException;
import com.sc.domain.UserDomain;
import com.sc.model.request.UpdateUserPwdModel;
import com.sc.model.request.UserModel;
import com.sc.service.IUserService;
import com.sc.support.AuthUser;
import com.sc.support.TokenService;
import com.sc.support.UserContext;
import com.sc.support.ValidatedGroup1;
import com.sc.support.ValidatedGroup2;
import com.sc.support.ValidatedGroup3;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	@Autowired
	private TokenService tokenService;


	/**
	 * 注册用户
	 */
	@RequestMapping(value = "/user/addUser", method = { RequestMethod.POST })
	public DataResponse addUserPost(@RequestBody @Validated(value = { ValidatedGroup2.class }) UserModel userModel) {
		DataResponse dr = null;
		try {
			userService.saveUser(userModel);
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
	 */
	@RequestMapping(value = "/outer/user/login", method = { RequestMethod.POST })
	public DataResponse login(@RequestBody @Validated(value = { ValidatedGroup3.class }) UserModel userModel,
			HttpServletRequest request, HttpServletResponse response) {
		DataResponse dr = null;
		try {
			UserDomain userDomain = userService.login(userModel);
			if (null != userDomain) {
				dr = produceToken(userDomain, request, response);
			} else {
				dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
			}
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
	 */
	@RequestMapping(value = "/user/logout", method = { RequestMethod.POST })
	public DataResponse logout() {
		tokenService.logout(UserContext.getAuthUser());
		return new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
	}

	/**
	 * 查询用户列表
	 */
	@RequestMapping(value = "/user/query/list", method = { RequestMethod.POST })
	public DataResponse queryUsertList(@RequestBody Map<String, String> paramMap) {
		DataResponse dr = null;
		try {
			List<UserDomain> userList = null;
			if (paramMap.get("deptId") != null) {
				userList = userService.queryByDeptId(Integer.parseInt(paramMap.get("deptId")));
			}else if (paramMap.get("refDeptId") != null || paramMap.get("refPosiId") != null) {
				userList = userService.queryByDeptOrPosiId(paramMap);
			} else {
				userList = userService.queryUsertList();
			}
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
			dr.put("userList", userList);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("查询用户列表异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	/**
	 * 查询当前用户
	 */
	@RequestMapping(value = "/user/currentUser", method = { RequestMethod.POST })
	public DataResponse queryCurrentUser(HttpServletRequest request) {
		DataResponse dr = null;
		try {
			Object userNameObj = request.getSession().getAttribute(CommonConstant.USER_NAME);
			if (null != userNameObj) {
				dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
				dr.put(CommonConstant.USER_NAME, String.valueOf(userNameObj));
			} else {
				dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
			}
		} catch (Exception e) {
			logger.error("获取登录用户异常：", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_FAIL);
		}
		return dr;
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/user/updatePwd", method = { RequestMethod.POST })
	public DataResponse updatePwd(@RequestBody @Validated UpdateUserPwdModel updateUserPwdModel) {
		DataResponse dr = null;
		try {
			userService.updatePwd(updateUserPwdModel);
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("修改密码异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}

	
	/**
	 * 删除用户
	 */
	@RequestMapping(value = "/user/delete", method = { RequestMethod.POST })
	public DataResponse deleteUserById(@RequestBody @Validated(value = { ValidatedGroup1.class} ) UserModel userModel) {
		DataResponse dr = null;
		try {
			userService.deleteUserById(userModel.getId());
			dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		} catch (ScException e) {
			logger.error(e.getMessage());
			dr = new DataResponse(e);
		} catch (Exception e) {
			logger.error("删除用户异常", e);
			dr = new DataResponse(ResponseEnum.RESPONSE_ERROR_SYSTEM);
		}
		return dr;
	}
	
	
	/************************ 以下为私有方法 ****************************/

	private DataResponse produceToken(UserDomain userDomain, HttpServletRequest request, HttpServletResponse response) {
		if (null == userDomain) {
			return new DataResponse(ResponseEnum.RESPONSE_FAIL);
		}
		// 设置token并且添加到redis
		AuthUser authUser = tokenService.generateAccessTokenByUser(userDomain);
		Cookie cookie = new Cookie(CommonConstant.ACCESS_TOKEN_KEY, authUser.getAccessToken());
		cookie.setPath(request.getContextPath() + "/");
		cookie.setMaxAge(3600);// 有效期10分钟
		response.addCookie(cookie);
		// 响应成功
		DataResponse dr = new DataResponse(ResponseEnum.RESPONSE_SUCCESS);
		dr.put(CommonConstant.ACCESS_TOKEN_KEY, authUser.getAccessToken());
		return dr;
	}

}
