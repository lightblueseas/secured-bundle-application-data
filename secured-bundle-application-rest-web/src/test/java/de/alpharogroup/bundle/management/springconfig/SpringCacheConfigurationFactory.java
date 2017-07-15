package de.alpharogroup.bundle.management.springconfig;

import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.core.io.ClassPathResource;

import com.google.common.collect.Lists;

/**
 * A factory for creating cache configuration objects.
 */
@Deprecated
public class SpringCacheConfigurationFactory
{

	/**
	 * New cache manager.
	 *
	 * @param cacheCacheManager the cache cache manager
	 * @return the cache manager
	 */
	public static CacheManager newCacheManager(final CacheManager... cacheCacheManager)
	{

		final List<CacheManager> cacheManagers = Lists.newArrayList();
		for (final CacheManager cm : cacheCacheManager)
		{
			if (cm != null)
			{
				cacheManagers.add(cm);
			}
		}

		final CompositeCacheManager cacheManager = new CompositeCacheManager();

		cacheManager.setCacheManagers(cacheManagers);
		cacheManager.setFallbackToNoOpCache(false);

		return cacheManager;
	}

	public static KeyGenerator newSimpleKeyGenerator()
	{
		return new SimpleKeyGenerator();
	}


	public static CacheResolver newSimpleCacheResolver()
	{
		return new SimpleCacheResolver();
	}


	public static CacheErrorHandler newSimpleCacheErrorHandler()
	{
		return new SimpleCacheErrorHandler();
	}


	/**
	 * New eh cache manager factory bean.
	 *
	 * @param ehcacheXmlFilename the ehcache xml filename
	 * @return the eh cache manager factory bean
	 */
	public static EhCacheManagerFactoryBean newEhCacheManagerFactoryBean(final String ehcacheXmlFilename)
	{
		final EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource(ehcacheXmlFilename));
		cacheManagerFactoryBean.setShared(true);
		return cacheManagerFactoryBean;
	}


    public static EhCacheCacheManager newEhCacheCacheManager(final EhCacheManagerFactoryBean cacheManagerFactoryBean) {
    	final EhCacheCacheManager cacheManger = new EhCacheCacheManager(cacheManagerFactoryBean.getObject());
        return cacheManger;
    }

}
