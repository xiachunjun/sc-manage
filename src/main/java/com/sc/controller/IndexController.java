package com.sc.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.sc.support.AuthUser;
import com.sc.support.UserContext;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/index")
	public String index(Map<String, Object> map) {
		AuthUser authUser = UserContext.getAuthUser();
		logger.info(JSONObject.toJSONString(authUser));
		return "/index";
	}
}
