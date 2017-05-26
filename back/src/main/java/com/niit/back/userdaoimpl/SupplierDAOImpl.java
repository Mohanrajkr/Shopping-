package com.niit.back.userdaoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.back.domain.Category;
import com.niit.back.domain.Supplier;
import com.niit.back.userdao.SupplierDAO;

@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean update(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
public List<Supplier> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}
	@Transactional
	public Supplier get(String supplierId) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(Supplier)  sessionFactory.getCurrentSession().get(Supplier.class, supplierId);
		
	}
	
	@Transactional
	public void delete(String supplierId) {
	Supplier supplierToDelete = new Supplier();
	supplierToDelete.setSupplierId(supplierId);
	sessionFactory.getCurrentSession().delete(supplierToDelete);
	}
}
