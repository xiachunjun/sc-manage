package com.sc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sc.support.AuthorizationInterceptor;

@Configuration
//@EnableWebMvc   //这个注解会是的前端传来的时间有时区问题
@ComponentScan({"com.sc.controller" ,"com.sc.support"})
public class WebConfig extends WebMvcConfigurerAdapter {
	static Logger logger = LoggerFactory.getLogger(WebConfig.class);
	
	@Autowired
	AuthorizationInterceptor authorizationInterceptor;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/demo/**").addResourceLocations("classpath:/demo/");
		//放行swagger路径
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration customer = registry.addInterceptor(authorizationInterceptor);
		customer.excludePathPatterns("/outer/**");
		
		customer.excludePathPatterns("/swagger-resources/**");
		customer.excludePathPatterns("/v2/**");
//		customer.excludePathPatterns("/**");
		
		customer.addPathPatterns("/**");
	}

	
}
