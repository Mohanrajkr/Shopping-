
package com.niit.back.userdao;

import java.util.List;

import com.niit.back.domain.Category;

public interface CategoryDAO{

	public  boolean save(Category category);
	
	// update the user details  - update
	public boolean update(Category category);
	
	// validate the credentials  -  validate
	//WE are going to use spring security in future.
	//we can delete this method. after using spring security.
	
	// get all users   - list
	
	public List<Category> list();
	
	
	//get user details based on userID
	
	public Category get(String id);
	
}
