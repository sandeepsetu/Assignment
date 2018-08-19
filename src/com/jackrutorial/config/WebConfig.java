package com.jackrutorial.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.*;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan({ "com.jackrutorial.config, com.jackrutorial.controller, com.jackrutorial.dao , com.jackrutorial.model, com.jackrutorial.service, com.jackrutorial.to" })
@PropertySource(value = { "classpath:config.properties" })
//@ComponentScan(basePackages = { "com.jackrutorial" })
public class WebConfig extends WebMvcConfigurerAdapter {
	@Autowired
	 private Environment environment;
	 @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.jackrutorial.model" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }

	 @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	        return dataSource;
	    }
	 
	 private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        return properties;        
	    }
	 
 @Bean
@Autowired
 public HibernateTransactionManager transactionManager(SessionFactory s)
 {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
 }
 
 @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {
  registry.addResourceHandler("resources/**").addResourceLocations("/resources/");
 }
 
 @Bean
 public InternalResourceViewResolver viewResolver(){
  InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
  viewResolver.setViewClass(JstlView.class);
  viewResolver.setPrefix("/WEB-INF/");
  viewResolver.setSuffix(".jsp");
  
  return viewResolver;
 }
 
 @Bean
 public HibernateTemplate htemplate(SessionFactory sf)
 {
 	HibernateTemplate htemp=new HibernateTemplate(sf);
 	return htemp;
 }
 
 @Bean
 public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
	return new PropertySourcesPlaceholderConfigurer();
 }	

 
}