package com.niit.back.userdaoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.back.domain.Category;
import com.niit.back.userdao.CategoryDAO;

public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	/**
	 * This save method create record in the User table.
	 * If the record is created successfully, it will return true
	 * else will return false
	 */
	@Transactional
	public boolean save(Category category) {
		try
		{
		sessionFactory.getCurrentSession().save(category);
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
	public boolean update(Category category) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * validate method will return true if the credetails are correct
	 * else will return false
	 */
	
	@Transactional
public List<Category> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	@Transactional
	public Category get(String categoryId) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(Category)  sessionFactory.getCurrentSession().get(Category.class, categoryId);
		
	}
	@Transactional
	public void delete(String categoryId) {
	Category categoryToDelete = new Category();
	categoryToDelete.setCategoryId(categoryId);
	sessionFactory.getCurrentSession().delete(categoryToDelete);
	}
}
