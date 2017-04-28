package com.niit.back.userdaoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.domain.Mycart;
import com.niit.back.userdao.MycartDAO;

@Repository("MycartDAO")
public class MycartDAOImpl implements MycartDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public MycartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	/**
	 * This save method create record in the User table.
	 * If the record is created successfully, it will return true
	 * else will return false
	 */
	@Transactional
	public boolean save(Mycart mycart) {
		try
		{
		sessionFactory.getCurrentSession().save(mycart);
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
	public boolean update(Mycart mycart) {
		try
		{
		sessionFactory.getCurrentSession().update(mycart);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
public List<Mycart> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from Mycart").list();
	}
	@Transactional
	public Mycart get(String productId) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(Mycart)  sessionFactory.getCurrentSession().get(Mycart.class, productId);
		
	}
}
