

package com.backSpringBatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManajerFactory", transactionManagerRef = "postgresTransactionManager",
basePackages = {"com.backSpringBatch.postgres.repository"})

public class ConfigurationPostgres {
	@Autowired
	private Environment env;
	
	@Bean(name = "postgresDataSource")
	public DataSource postgresDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("postgres.spring.datasource.url"));
		dataSource.setUsername(env.getProperty("postgres.spring.datasource.username"));
		dataSource.setPassword(env.getProperty("postgres.spring.datasource.password"));
		//dataSource.setDriverClassName(env.getProperty("postgres.spring.datasource.driver-class-name"));
		
		return dataSource;
	}
	
	@Primary
	@Bean(name = "postgresEntityManajerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(postgresDataSource());
		lcemfb.setPackagesToScan("com.backSpringBatch.postgres.entity");
		
		HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
		lcemfb.setJpaVendorAdapter(hjva);
		
		Map<String, Object> mProperties = new HashMap<>();
		mProperties.put("hibernate.show-sql", env.getProperty("postgres.spring.jpa.show-sql"));
		mProperties.put("hibernate.dialect", env.getProperty("postgres.spring.jpa.database-platform"));
//		mProperties.put("hibernate.default_schema", env.getProperty("postgres.gateway.jpa.schema-default"));
		lcemfb.setJpaPropertyMap(mProperties);
		
		return lcemfb;
	}
	

	@Bean(name = "postgresTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager jtm = new JpaTransactionManager();
		jtm.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return jtm;
	}
}