package com.niit.back.userdaoimpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.back.domain.ShippingAddress;
import com.niit.back.userdao.ShippingAddressDAO;


@Repository("ShippingAddressDAO")
public class ShippingAddressDAOImpl implements ShippingAddressDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public ShippingAddressDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	/**
	 * This save method create record in the User table.
	 * If the record is created successfully, it will return true
	 * else will return false
	 */
	@Transactional
	public boolean save(ShippingAddress shippingaddress) {
		try
		{
		sessionFactory.getCurrentSession().save(shippingaddress);
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
	public boolean update(ShippingAddress shippingaddress) {
		try
		{
		sessionFactory.getCurrentSession().update(shippingaddress);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
public List<ShippingAddress> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from ShippingAddress").list();
	}
	@Transactional
	public ShippingAddress get(String shippingId) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(ShippingAddress)  sessionFactory.getCurrentSession().get(ShippingAddress.class, shippingId);
		
	}
}
