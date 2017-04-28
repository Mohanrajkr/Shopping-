package com.niit.back;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.back.domain.ShippingAddress;
import com.niit.back.userdao.ShippingAddressDAO;

public class ShippingAddressDAOTestCase {
@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static ShippingAddressDAO  shippingaddressDAO;
	
	@Autowired  static ShippingAddress shippingaddress;
	
	
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
		shippingaddressDAO =  (ShippingAddressDAO) context.getBean("shippingaddressDAO");
		
		//get the user from context
		
		shippingaddress = (ShippingAddress)context.getBean("shippingaddress");
		
	}
	
	@Test
	public void createShippingAddressTestCase()
	{
		shippingaddress.setUserId("21");
		shippingaddress.setUserName("dress");
		shippingaddress.setEmail("raj456@gmail.com");
		shippingaddress.setAddress("covai");
		shippingaddress.setMobileNumber("9874563456");
		boolean flag =  shippingaddressDAO.save(shippingaddress);
		System.out.println(flag);
		

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createShippingAddressTestCase",true,flag);
		
		
	}
}
