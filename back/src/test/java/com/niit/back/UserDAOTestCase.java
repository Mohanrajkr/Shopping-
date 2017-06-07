package com.niit.back;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.back.dao.RoleDAO;
import com.niit.back.dao.UserDAO;
import com.niit.back.domain.Role;
import com.niit.back.domain.User;

public class UserDAOTestCase {
	
@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static UserDAO  userDAO;
	
	@Autowired  static User user;
	

	@Autowired
	static RoleDAO roleDAO;

	@Autowired
	static Role role;
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

		user = (User)context.getBean("user");
		
		roleDAO = (RoleDAO) context.getBean("RoleDAO");

		role = (Role) context.getBean("role");

	}

	@Test
	public void createUserTestCase()
	{
		
	
		user.setUserName("Ram");
		user.setPassword("45");
		user.setMobileNumber("8807761502");
		user.setEmail("ram@gmail.com");
		user.setAddress("Tirupur");
		user.setZipcode("5289");
		boolean flag =  userDAO.save(user);
		System.out.println(flag);
		
		
		role.setEmail("hi");
		role.setRole("ROLE_USER");
		role.setUserName("bye");
		
		
		user.setRole(role);
		role.setUser(user);

		boolean flag1 = roleDAO.save(role);
	

		System.out.println(flag1);
		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createUserTestCase",true,flag);
		assertEquals("createUserTestCase",true,flag1);
		
	}
	
}
