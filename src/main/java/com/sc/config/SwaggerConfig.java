package com.sc.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

/**
 *  浏览器中输入该地址：http://localhost:8090/swagger-ui.html
 *	即可看到后端所有接口，方便测试接口，以及方便前后端进行联调接口，不需再写接口文档
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${system.enableSwagger}")
	private String enableSwagger;
	
	@SuppressWarnings("unchecked")
	@Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                if (declaringClass == BasicErrorController.class)// 排除
                    return false;
                if(declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                    return true;
                if(input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
                    return true;
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(isEnable())
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")  // base，最终调用接口后会和paths拼接在一起
                .select()
                .paths( or( regex("/.*") /*, regex("/.*")*/ ) )  // 过滤的接口
                .apis(predicate)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("sc-manage")//大标题
            .version("1.0")//版本
            .build();
    }
    
    private Boolean isEnable(){
    	return StringUtils.equals("true", enableSwagger);
	}
	    
}



