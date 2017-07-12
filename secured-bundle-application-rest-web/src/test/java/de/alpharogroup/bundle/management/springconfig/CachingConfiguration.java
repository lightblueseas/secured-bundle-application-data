/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.bundle.management.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return SpringCacheConfigurationFactory.newCacheManager(this.ehCacheCacheManager, this.redisCacheManager);
    }


    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return SpringCacheConfigurationFactory.newSimpleKeyGenerator();
    }


	@Override
	public CacheResolver cacheResolver()
	{
        return SpringCacheConfigurationFactory.newSimpleCacheResolver();
	}


	@Override
	public CacheErrorHandler errorHandler()
	{
        return SpringCacheConfigurationFactory.newSimpleCacheErrorHandler();
	}
}