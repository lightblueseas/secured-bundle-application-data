package de.alpharogroup.bundle.management.springconfig;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class EhCacheConfiguration {

    @Bean
    public EhCacheCacheManager ehCacheCacheManager() {
    	final EhCacheCacheManager cacheManger = new EhCacheCacheManager(ehCacheManagerFactoryBean().getObject());
        return cacheManger;
    }


    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {

        final EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();

        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);

        return cacheManagerFactoryBean;
    }
}