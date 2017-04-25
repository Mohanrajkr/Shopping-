package com.niit.back;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.back.userdao.CategoryDAO;
import com.niit.back.domain.Category;

public class CategoryDAOTestCase {
@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static CategoryDAO  categoryDAO;
	
	@Autowired  static Category category;
	
	
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
		categoryDAO =  (CategoryDAO) context.getBean("categoryDAO");
		
		//get the user from context
		
		category = (Category)context.getBean("category");
		
	}
	
	@Test
	public void createCategoryTestCase()
	{
		category.setCategoryName("pots");
		category.setDescription("home product");
		boolean flag =  categoryDAO.save(category);
		System.out.println("");
		
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createCategoryTestCase",true,flag);
		
	}
	
	
}
