package com.niit.back.userdao;

import java.util.List;


import com.niit.back.domain.BillingAddress;


public interface BillingAddressDAO {
	public  boolean save(BillingAddress billingaddress);
	
	// update the user details  - update
	public boolean update(BillingAddress billingaddress);
	
	
	// get all users   - list
	
	public List<BillingAddress>     list();
	
	
	//get user details based on userID
	
	public BillingAddress get(String billingId);
	
}
