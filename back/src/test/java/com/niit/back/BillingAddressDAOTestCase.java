package com.niit.back;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.back.domain.BillingAddress;
import com.niit.back.userdao.BillingAddressDAO;

public class BillingAddressDAOTestCase {
@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static BillingAddressDAO  billingaddressDAO;
	
	@Autowired  static BillingAddress billingaddress;
	
	
	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.back");
		context.refresh();
		
		//get the userDAO from context
		billingaddressDAO =  (BillingAddressDAO) context.getBean("billingaddressDAO");
		
		//get the user from context
		
		billingaddress = (BillingAddress)context.getBean("billingaddress");
		
	}
	
	@Test
	public void createBillingAddressTestCase()
	{
		billingaddress.setUserId("21");
		billingaddress.setUserName("dress");
		billingaddress.setEmail("raj456@gmail.com");
		billingaddress.setAddress("covai");
		billingaddress.setMobileNumber("9874563456");
		boolean flag =  billingaddressDAO.save(billingaddress);
		System.out.println(flag);
		

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createBillingAddressTestCase",true,flag);
		
		
	}
}
