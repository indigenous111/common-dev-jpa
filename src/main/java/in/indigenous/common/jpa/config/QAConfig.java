package in.indigenous.common.jpa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ConfigurationProperties(prefix = "spring.qa")
@EntityScan(basePackages = { "in.indigenous.common.jpa.entity" })
@EnableJpaRepositories(basePackages = {
		"in.indigenous.common.jpa.repository.qa" }, transactionManagerRef = "qaTransactionManager", entityManagerFactoryRef = "qaEntityManagerFactory")
public class QAConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource qaDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.qa.datasource.driver"));
		dataSource.setUrl(env.getProperty("spring.qa.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.qa.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.qa.datasource.password"));
		return dataSource;
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean qaEntityManagerFactory(
			@Qualifier("qaDataSource") DataSource dataSource) {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setPackagesToScan("in.indigenous.common.jpa.entity.qa");
		factoryBean.setJpaProperties(additionalProperties());
		return factoryBean;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager qaTransactionManager(
			@Qualifier("qaEntityManagerFactory") LocalContainerEntityManagerFactoryBean qaEntityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(qaEntityManagerFactory.getObject());
		return transactionManager;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDB53Dialect");
		return properties;
	}
}
