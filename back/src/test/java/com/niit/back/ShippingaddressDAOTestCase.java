package com.niit.back;



import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.back.dao.ShippingaddressDAO;
import com.niit.back.domain.Shippingaddress;


public class ShippingaddressDAOTestCase {
@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static ShippingaddressDAO  shippingaddressDAO;
	
	@Autowired  static Shippingaddress  shippingaddress;
	

	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		shippingaddressDAO =  (ShippingaddressDAO) context.getBean("ShippingaddressDAO");
		
		//get the user from context
		
		shippingaddress = (Shippingaddress)context.getBean("shippingaddress");
		
	}
	
	@Test
	public void createShippingaddressTestCase()
	{
		shippingaddress.setUserName("jenu");
		shippingaddress.setEmail("jenu@gmail.com");
		shippingaddress.setMobileNumber("9012679872");
		shippingaddress.setAddress("mumbai");
		shippingaddress.setZipcode(576878);
		shippingaddressDAO.saveOrUpdate(shippingaddress);
	}
		
}
