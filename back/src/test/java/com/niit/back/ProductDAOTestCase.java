package com.niit.back;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.back.domain.Product;
import com.niit.back.userdao.ProductDAO;

public class ProductDAOTestCase {
@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static ProductDAO  productDAO;
	
	@Autowired  static Product product;
	
	
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
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		//get the user from context
		
		product = (Product)context.getBean("product");
		
	}
	
	@Test
	public void createProductTestCase()
	{
		product.setProductName("pots");
		product.setPrize("456");
		product.setQuantity("8");
		product.setDescription("home product");
		boolean flag =  productDAO.save(product);
		System.out.println(flag);
		
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createProductTestCase",true,flag);
		
		
	}
}
