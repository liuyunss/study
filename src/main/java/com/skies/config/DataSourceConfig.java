package com.skies.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 多数据源配置
 */
@Configuration
public class DataSourceConfig {

	@Bean(value = "primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(value = "secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(value = "thirdJdbcTemplate")
	public JdbcTemplate thirdJdbcTemplate(@Qualifier("thirdDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Primary
	@Bean(value = "primaryDataSourceProperties")
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSourceProperties primaryDataSourceProperties() {
		return new DataSourceProperties();
	}


	@Bean(value = "secondaryDataSourceProperties")
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public DataSourceProperties secondaryDataSourceProperties() {
		return new DataSourceProperties();
	}


	@Bean(value = "thirdDataSourceProperties")
	@ConfigurationProperties(prefix = "spring.datasource.third")
	public DataSourceProperties thirdDataSourceProperties() {
		return new DataSourceProperties();
	}


	@Bean(value = "primaryDataSource")
	public DataSource primaryDataSource() {
		return primaryDataSourceProperties().initializeDataSourceBuilder().build();
	}


	@Bean(value = "secondaryDataSource")
	public DataSource secondaryDataSource() {
		return secondaryDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean(value = "thirdDataSource")
	public DataSource thirdDataSource() {
		return thirdDataSourceProperties().initializeDataSourceBuilder().build();
	}

	/******配置事务管理********/

	@Bean(value = "primaryTransactionManager")
	public PlatformTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource")DataSource primaryDataSource) {
		return new DataSourceTransactionManager(primaryDataSource);
	}

	@Bean(value = "secondaryTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(@Qualifier("secondaryDataSource")DataSource secondaryDataSource) {
		return new DataSourceTransactionManager(secondaryDataSource);
	}

	@Bean(value = "thirdTransactionManager")
	public PlatformTransactionManager thirdTransactionManager(@Qualifier("thirdDataSource")DataSource thirdDataSource) {
		return new DataSourceTransactionManager(thirdDataSource);
	}

}
