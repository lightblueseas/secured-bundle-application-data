package de.alpharogroup.bundle.management.springconfig;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

public class SpringEntityManagerFactory
{


	public static JpaVendorAdapter newJpaVendorAdapter(Database db)
	{
		final HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(db);
		return hibernateJpaVendorAdapter;
	}

	public static DataSource newDataSource(final DataSourceBean dataSourceBean)
	{
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dataSourceBean.getDriverClassName());
		dataSource.setUrl(dataSourceBean.getUrl());
		dataSource.setUsername(dataSourceBean.getUsername());
		dataSource.setPassword(dataSourceBean.getPassword());
		return dataSource;
	}


	public static JdbcTemplate newJdbcTemplate(DataSource dataSource)
	{
		JdbcTemplate jdbcTemplate;
		jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	public static JpaTransactionManager newTransactionManager(
		EntityManagerFactory entityManagerFactory)
	{
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}


	public static LocalContainerEntityManagerFactoryBean newEntityManagerFactoryBean(
		String persistenceUnitName, DataSource dataSource, JpaVendorAdapter vendorAdapter,
		Properties jpaProperties)
	{
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		em.setPersistenceUnitName(persistenceUnitName);
		em.setDataSource(dataSource);

		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(jpaProperties);
		return em;
	}

}
