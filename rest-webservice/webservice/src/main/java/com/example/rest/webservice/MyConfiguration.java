package com.example.rest.webservice;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {
		"com.example.rest.webservice.repository" }, entityManagerFactoryRef = "h2EntityManagerFactory", transactionManagerRef = "transactionManager")
public class MyConfiguration {

	@Autowired
	private Environment env;
	 
    @Value("${hibernate.dialect}")         private String hibernateDialect;
    @Value("${hibernate.show_sql}")     private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddlAuto;
        
    @Bean()    
    public DataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();        
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
 
        System.out.println("## getDataSource: " + dataSource);
        
        return dataSource;
    }
    
    @Bean(name="transactionManager")
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }
    
    @Bean
    @Autowired
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
    {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }
        
    @Bean
    @Primary
    public LocalSessionFactoryBean getSessionFactory()
    {
    	LocalSessionFactoryBean asfb = new LocalSessionFactoryBean();
        asfb.setDataSource(getDataSource());
        asfb.setHibernateProperties(getHibernateProperties());        
        asfb.setPackagesToScan(new String[]{" com.example.rest.webservice.model"});
        return asfb;
    }

    @Bean
    public Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        
        return properties;
    }
    
    /// Entity Manager Factory
    @Bean(name = "h2EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaProperties databaseProperties,
			DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(new String[] {"com.example.rest.webservice.model" });

		AbstractJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(databaseProperties.isShowSql());
		vendorAdapter.setDatabase(databaseProperties.getDatabase());
		vendorAdapter.setDatabasePlatform(databaseProperties.getDatabasePlatform());
		vendorAdapter.setGenerateDdl(databaseProperties.isGenerateDdl());
		em.setJpaVendorAdapter(vendorAdapter);
		return em;
	}
    @Bean
	@Primary
	@ConfigurationProperties(prefix = "h2.jpa")
	public JpaProperties databaseProperties() {
		return new JpaProperties();
	}

}
