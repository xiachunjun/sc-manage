package com.sc.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sc.common.constant.CommonConstant;
import com.sc.model.response.UserInfoResult;
import com.sc.service.IPositionService;
import com.sc.service.IUserService;
import com.sc.support.AuthUser;
import com.sc.support.UserContext;

/**
 * 通用的页面跳转逻辑(jsp,freemarker,vm等)，  如：(localhost:8090/page/页面文件名称)
 */
@Controller
public class PageController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IPositionService positionService;
	
	
    @RequestMapping(value = "/page/{pageName}", method = RequestMethod.GET)
    public String toPage(@PathVariable("pageName") String pageName) {
        return pageName;
    }

    @RequestMapping(value = "/page/{pagePath}/{pageName}", method = RequestMethod.GET)
    public String toPage(@PathVariable("pagePath") String pagePath,
    		@PathVariable("pageName") String pageName) {
        return pagePath+"/"+pageName;
    }
    
    
    /**
     * 跳转用户登录页面
     */
    @RequestMapping("/outer/login")
	public String loginPage(Map<String, Object> map) {
		return "/login";
	}
    
    
    /**
	 * 跳转到部门或岗位的一二级职责页面
	 */
	@RequestMapping(value = "/to/duty/detail", method = { RequestMethod.GET })
	public ModelAndView toDutyDetail(@RequestParam Map<String, Object> map,
			@RequestParam(name="qId", required=true)Integer qId,
			@RequestParam(name="type", required=true)String type) {
		ModelAndView mv = new ModelAndView("/duty/dutyDetail");
		if(StringUtils.equals(CommonConstant.DEPT, type)){
			map.put("dutyTypeName", "部门");
			map.put("dutyDeptEntityName", map.get("name"));
			map.put("dutyPosiEntityName", "");
		}else if(StringUtils.equals(CommonConstant.POSI, type)){
			String deptName = positionService.queryDeptNameByPosiId(qId);
			map.put("dutyTypeName", "岗位");
			map.put("dutyDeptEntityName", deptName);
			map.put("dutyPosiEntityName", map.get("name"));
		}
		map.put("dutyEntityType", type);
		map.put("dutyEntityCode", qId);
		
		mv.addAllObjects(map);
		return mv;
	}
    
    
	@RequestMapping("/plan/planManage")
	public ModelAndView planManage() {
		ModelAndView mv = new ModelAndView("/plan/planManage");
		AuthUser authUser = UserContext.getAuthUser();
		if(null != authUser){
			//查询登录人的姓名，部门，岗位
			UserInfoResult userInfo = userService.queryUserInfoByUserId(authUser.getId());
			mv.addObject("userInfo", userInfo);
		}
		return mv;
	}

	
	@RequestMapping("/plan/addPlan")
	public ModelAndView addPlan() {
		ModelAndView mv = new ModelAndView("/plan/addPlan");
		AuthUser authUser = UserContext.getAuthUser();
		if(null != authUser){
			//查询登录人的姓名，部门，岗位
			UserInfoResult userInfo = userService.queryUserInfoByUserId(authUser.getId());
			mv.addObject("userInfo", userInfo);
		}
		return mv;
	}
	
	
	
}
