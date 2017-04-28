package com.niit.back.userdao;

import java.util.List;

import com.niit.back.domain.Supplier;

public interface SupplierDAO  {
	public  boolean save(Supplier supplier);
	
	// update the user details  - update
	public boolean update(Supplier supplier);
	
	// validate the credentials  -  validate
	//WE are going to use spring security in future.
	//we can delete this method. after using spring security.

	
	// get all users   - list
	
	public List<Supplier>     list();
	
	
	//get user details based on userID
	
	public Supplier get(String supplierId);
	
	
	
}
