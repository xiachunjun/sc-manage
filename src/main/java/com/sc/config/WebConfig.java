package com.sc.config;

import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sc.support.AuthorizationInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.sc.controller, com.sc.support")
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
		customer.addPathPatterns("/**");
	}

	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
	    MultipartConfigFactory factory = new MultipartConfigFactory();
	    //置文件大小限制 ,超出此大小页面会抛出异常信息
	    //factory.setMaxFileSize("2MB"); //KB,MB
	    //设置总上传数据总大小
	    //factory.setMaxRequestSize("20MB");
	    //设置文件临时文件夹路径
	    //factory.setLocation("E://tmp//sc-manange//");
	    //如果文件大于这个值，将以文件的形式存储，如果小于这个值文件将存储在内存中，默认为0
	    //factory.setMaxRequestSize(0);
	    return factory.createMultipartConfig();
	}
	
	
}
