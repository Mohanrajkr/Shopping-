package com.niit.back.config;

import java.util.Properties;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.back.domain.Category;
import com.niit.back.domain.Product;
import com.niit.back.domain.Supplier;
import com.niit.back.domain.User;
import com.niit.back.userdao.CategoryDAO;
import com.niit.back.userdao.ProductDAO;
import com.niit.back.userdao.SupplierDAO;
import com.niit.back.userdao.UserDAO;
import com.niit.back.userdaoimpl.CategoryDAOImpl;
import com.niit.back.userdaoimpl.ProductDAOImpl;
import com.niit.back.userdaoimpl.SupplierDAOImpl;
import com.niit.back.userdaoimpl.UserDAOImpl;

@Configuration
@ComponentScan("com.niit.back")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {


		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/HomePlus");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");

		return properties;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Category.class);


		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
	
	@Autowired(required = true)
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
		return  new UserDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		return   new CategoryDAOImpl(sessionFactory);
	}
	@Autowired(required = true)
	@Bean(name = "productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) {
		return   new ProductDAOImpl(sessionFactory);
	}

	@Autowired(required = true)
	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) {
		return   new SupplierDAOImpl(sessionFactory);
	}

}
