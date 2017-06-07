package com.niit.back.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.back.dao.BillingaddressDAO;
import com.niit.back.domain.Billingaddress;
@Repository("BillingaddressDAO")
public class BillingaddressDAOImpl implements BillingaddressDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public BillingaddressDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	/**
	 * This save method create record in the User table.
	 * If the record is created successfully, it will return true
	 * else will return false
	 */
	@Transactional
	public boolean save(Billingaddress billingaddress) {
		try
		{
		sessionFactory.getCurrentSession().save(billingaddress);
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
	public boolean update(Billingaddress billingaddress) {
		try
		{
		sessionFactory.getCurrentSession().update(billingaddress);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
public List<Billingaddress> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from BillingAddress").list();
	}
	@Transactional
	public Billingaddress get(String billingId) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(Billingaddress)  sessionFactory.getCurrentSession().get(Billingaddress.class, billingId);
		
	}
}
