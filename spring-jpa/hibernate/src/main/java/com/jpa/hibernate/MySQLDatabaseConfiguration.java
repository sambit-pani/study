package com.jpa.hibernate;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mysqlEntityManagerFactory",
				transactionManagerRef = "mysqlTransactionManager", 
				basePackages = {"com.jpa.hibernate.repository" })
public class MySQLDatabaseConfiguration {
	
	@Bean(name = "mysqlDatasource")
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource dataSource() {
		DataSource dataSource = DataSourceBuilder.create().build();
		return dataSource;
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "mysql.jpa")
	public JpaProperties mysqlProperties() {
		return new JpaProperties();
	}

	@Bean(name = "mysqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaProperties mysqlJpaProperties,DataSource dataSource) {
		 LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource);
	      em.setPackagesToScan(new String[] { "com.jpa.hibernate.model" });
	 
	      JpaVendorAdapter vendorAdapter = createJpaVendorAdapter(mysqlJpaProperties);
	      em.setJpaVendorAdapter(vendorAdapter);
	     //em.setJpaProperties(additionalProperties());
	      
	      return em;
	}

	/*private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(JpaProperties mysqlJpaProperties) {
		JpaVendorAdapter jpaVendorAdapter = createJpaVendorAdapter(mysqlJpaProperties);
		return new EntityManagerFactoryBuilder(jpaVendorAdapter, mysqlJpaProperties.getProperties(),
				this.persistenceUnitManager);
	}*/

	private JpaVendorAdapter createJpaVendorAdapter(JpaProperties jpaProperties) {
		AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(jpaProperties.isShowSql());
		adapter.setDatabase(jpaProperties.getDatabase());
		adapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
		adapter.setGenerateDdl(jpaProperties.isGenerateDdl());
		return adapter;
	}

	@Bean(name = "mysqlTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	/*Properties additionalProperties() {
	       Properties properties = new Properties();
	       //properties.setProperty("hibernate.hbm2ddl.auto", "create");
	       properties.setProperty(
	         "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	       properties.setProperty(
	  	         "hibernate.show_sql", "true");
	        
	       return properties;
	   }*/
}
