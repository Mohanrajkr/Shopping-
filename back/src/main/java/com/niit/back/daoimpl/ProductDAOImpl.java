package com.niit.back.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.back.dao.ProductDAO;
import com.niit.back.domain.Mycart;
import com.niit.back.domain.Product;
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	/**
	 * This save method create record in the User table.
	 * If the record is created successfully, it will return true
	 * else will return false
	 */
	@Transactional
	public boolean save(Product product) {
		try
		{
		sessionFactory.getCurrentSession().save(product);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * This update method update record in the User table.
	 * If the record is updated successfully, it will return true
	 * else will return false
	 */
	
	
	@Transactional
	public boolean saveOrUpdate(Product product) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		}catch (Exception e) {
						e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
public List<Product> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
	@Transactional
	public Product get(int productId) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(Product)  sessionFactory.getCurrentSession().get(Product.class, productId);
		
	}
	@Transactional
	public void delete(int productId) {
	Product productToDelete = new Product();
	productToDelete.setProductId(productId);
	sessionFactory.getCurrentSession().delete(productToDelete);
	}
}
