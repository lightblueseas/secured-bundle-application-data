package de.alpharogroup.bundle.management.springconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

@Configuration
@EnableCaching
public class CachingConfiguration implements CachingConfigurer {

    @Qualifier("ehCacheCacheManager")
    @Autowired(required = false)
    private CacheManager ehCacheCacheManager;

    @Qualifier("redisCacheManager")
    @Autowired(required = false)
    private CacheManager redisCacheManager;

    @Bean
    @Override
    public CacheManager cacheManager() {

        final List<CacheManager> cacheManagers = Lists.newArrayList();

        if (this.ehCacheCacheManager != null) {
            cacheManagers.add(this.ehCacheCacheManager);
        }

        if (this.redisCacheManager != null) {
            cacheManagers.add(this.redisCacheManager);
        }

        final CompositeCacheManager cacheManager = new CompositeCacheManager();

        cacheManager.setCacheManagers(cacheManagers);
        cacheManager.setFallbackToNoOpCache(false);

        return cacheManager;
    }


    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }


	@Override
	public CacheResolver cacheResolver()
	{
        return new SimpleCacheResolver();
	}


	@Override
	public CacheErrorHandler errorHandler()
	{
        return new SimpleCacheErrorHandler();
	}
}