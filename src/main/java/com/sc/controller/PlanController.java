package com.sc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlanController {

	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);

	@RequestMapping("/plan/planList")
	public String planList() {
		return "/planList";
	}
	
	@RequestMapping("/plan/planManage")
	public String planManage() {
		return "/planManage";
	}
	
	@RequestMapping("/plan/addPlan")
	public String addPlan() {
		return "/addPlan";
	}
	
}
