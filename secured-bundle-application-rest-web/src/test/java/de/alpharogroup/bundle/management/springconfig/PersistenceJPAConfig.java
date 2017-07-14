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

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Import({ EhCacheConfiguration.class, CachingConfiguration.class })
@ComponentScan(basePackages = { "de.alpharogroup.db.resource.bundles.*",
		"de.alpharogroup.db.resource.bundles.*.*",

		"de.alpharogroup.address.book.*", "de.alpharogroup.address.book.*.*",

		"de.alpharogroup.resource.system.*", "de.alpharogroup.resource.system.*.*",

		"de.alpharogroup.user.*", "de.alpharogroup.user.*.*",

		"de.alpharogroup.user.management.*", "de.alpharogroup.user.management.*.*", })
public class PersistenceJPAConfig
{
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private DataSource dataSource;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
	{
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		em.setPersistenceUnitName("bundlemanagement");
		em.setDataSource(dataSource());

		final JpaVendorAdapter vendorAdapter = SpringEntityManagerFactory.newJpaVendorAdapter(Database.H2);
			new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		em.afterPropertiesSet();
		return em;
	}

	@Bean
	public DataSource dataSource()
	{

		final JdbcUrlBean bean = JdbcUrlBean.builder().protocol("jdbc:h2:")
			.database("file:~/bundlemanagement").parameter("MODE=PostgreSQL")
			.parameter("DB_CLOSE_ON_EXIT=FALSE").parameter("DB_CLOSE_DELAY=-1").build();

		final DataSourceBean dataSourceBean = DataSourceBean.builder()
			.url(JdbcUrlBean.newH2JdbcUrl(bean)).driverClassName("org.h2.Driver").username("sa")
			.password("").build();

		return SpringEntityManagerFactory.newDataSource(dataSourceBean);
	}

	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		final JdbcTemplate jdbcTemplate = SpringEntityManagerFactory.newJdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	@Bean
	public PlatformTransactionManager transactionManager()
	{
		final JpaTransactionManager transactionManager = SpringEntityManagerFactory
			.newTransactionManager(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
	{
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties()
	{
		final Properties properties = new Properties();
		properties.setProperty("hibernate.generateDdl", "true");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.database", "H2");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	Properties hibernateProperties()
	{
		final Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.connection.characterEncoding", "UTF-8");
		hibernateProperties.put("hibernate.connection.charSet", "UTF-8");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.format_sql", "true");
		// hibernateProperties.put("hibernate.generate_statistics",
		// env.getProperty("hibernate.generate_statistics"));
		hibernateProperties.put("hibernate.enable_lazy_load_no_trans", "true");

		// second level cache
		hibernateProperties.put("hibernate.cache.use_second_level_cache", "true");
		hibernateProperties.put("hibernate.cache.use_query_cache", "true");
		hibernateProperties.put("hibernate.cache.region.factory_class",
			"org.hibernate.cache.ehcache.EhCacheRegionFactory");
		// hibernateProperties.put("net.sf.ehcache.configurationResourceName",
		// env.getProperty("net.sf.ehcache.configurationResourceName"));

		// testing
		hibernateProperties.put("hibernate.bytecode.use_reflection_optimizer", false);
		hibernateProperties.put("hibernate.check_nullability", false);
		hibernateProperties.put("hibernate.search.autoregister_listeners", false);
		return hibernateProperties;
	}
}
