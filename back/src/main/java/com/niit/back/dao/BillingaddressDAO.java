package com.niit.back.dao;

import java.util.List;


import com.niit.back.domain.Billingaddress;


public interface BillingaddressDAO {
	public  boolean save(Billingaddress billingaddress);
	
	// update the user details  - update
	public boolean update(Billingaddress billingaddress);
	
	
	// get all users   - list
	
	public List<Billingaddress>     list();
	
	
	//get user details based on userID
	
	public Billingaddress get(String billingId);
	
}
