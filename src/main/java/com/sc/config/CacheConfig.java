package com.sc.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 在service方法上添加以下注解：
 * 	1.添加到缓存(查询方法， pId为传入参数)： 
 * 		@Cacheable(value="sc-manage", key="#pId")
 *  2.清除缓存(插入，修改，删除方法)：  
 *    	@CacheEvict(value="sc-manage", allEntries=true, beforeInvocation=true)
 */
@Configuration
@EnableCaching  //标注启动了缓存
public class CacheConfig {

    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
        return new EhCacheCacheManager(bean.getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }
	
}
