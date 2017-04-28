package com.niit.back.userdao;

import java.util.List;

import com.niit.back.domain.User;

public interface UserDAO {
	
		public  boolean save(User user);
		
		// update the user details  - update
		public boolean update(User user);
		
		// validate the credentials  -  validate
		//WE are going to use spring security in future.
		//we can delete this method. after using spring security.
		/*public boolean validate(String id, String password);*/
		
		// get all users   - list
		
		public List<User>     list();
		
		
		//get user details based on userID
		
		public User get(String userId);
		
		
		
		
		
		
		
		
		
		
}
