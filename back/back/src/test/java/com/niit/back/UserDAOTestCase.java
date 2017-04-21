package com.niit.back;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.back.domain.User;
import com.niit.back.userdao.UserDAO;

public class UserDAOTestCase {
	
@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static UserDAO  userDAO;
	
	@Autowired  static User user;
	
	
	
	public UserDAOTestCase() {
		initialize();
		createUserTestCase();
		// TODO Auto-generated constructor stub
	}

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
		userDAO =  (UserDAO) context.getBean("userDAO");
		
		//get the user from context
		
		user = (User)context.getBean("user");
		
	}

	@Test
	public void createUserTestCase()
	{
		
		user.setUserid("123");
		user.setUsername("Ravi");
		user.setPassword("456");
		user.setMobilenumber("8807761501");
		user.setAddress("Coimbatore");
		boolean flag =  userDAO.save(user);
		System.out.println(flag);
		
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createUserTestCase",true,flag);
		
	}
	
	
}
