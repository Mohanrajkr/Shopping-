package com.niit.back;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.back.dao.SupplierDAO;
import com.niit.back.domain.Supplier;

public class SupplierDAOTestCase {
@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static SupplierDAO  supplierDAO;
	
	@Autowired  static Supplier supplier;
	
	
	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		supplierDAO =  (SupplierDAO) context.getBean("supplierDAO");
		
		//get the user from context
		
		supplier = (Supplier)context.getBean("supplier");
		
	}
	
	@Test
	public void createSupplierTestCase()
	{
		supplier.setSupplierName("mohan");
		supplier.setMobileNumber("88066");
	    supplier.setAddress("tirupur");
		boolean flag =  supplierDAO.save(supplier);
		System.out.println(flag);
		
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createSupplierTestCase",true,flag);
		
		
	}
	
}
