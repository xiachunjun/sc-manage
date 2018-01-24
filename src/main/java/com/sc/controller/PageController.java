package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 通用的页面跳转逻辑(jsp,freemarker,vm等)，  如：(localhost:8090/page/页面文件名称)
 */
@RequestMapping("/page")
@Controller
public class PageController {

	
    @RequestMapping(value = "{pageName}", method = RequestMethod.GET)
    public String toPage(@PathVariable("pageName") String pageName) {
        return pageName;
    }

    
    @RequestMapping(value = "{pagePath}/{pageName}", method = RequestMethod.GET)
    public String toPage(@PathVariable("pagePath") String pagePath,
    		@PathVariable("pageName") String pageName) {
        return pagePath+"/"+pageName;
    }
    
}
