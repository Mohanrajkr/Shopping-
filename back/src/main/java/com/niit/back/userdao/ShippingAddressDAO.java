package com.niit.back.userdao;

import java.util.List;


import com.niit.back.domain.ShippingAddress;

public interface ShippingAddressDAO {
	public  boolean save(ShippingAddress shippingaddress);
	
	// update the user details  - update
	public boolean update(ShippingAddress shippingaddress);
	
	
	// get all users   - list
	
	public List<ShippingAddress>     list();
	
	
	//get user details based on userID
	
	public ShippingAddress get(String shippingId);
	
}
