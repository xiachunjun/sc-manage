package com.sc.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);	
	
	@Autowired
	RedisTemplate<Object,Object> redisTemplate;
	   @RequestMapping("/index")  
	    public String helloHtml(Map<String,Object> map){
		   redisTemplate.opsForValue().set("111", "222");
		  String aa=String.valueOf(redisTemplate.opsForValue().get("111")); 
		  System.out.println(aa);
	       map.put("hello","from TemplateController.helloHtml");  
	       return"/index";  
	    }  
}
