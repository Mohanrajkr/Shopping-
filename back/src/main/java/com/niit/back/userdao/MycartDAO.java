package com.niit.back.userdao;

import java.util.List;

import com.niit.back.domain.Mycart;

public interface MycartDAO {
public  boolean save(Mycart mycart);
	
	// update the user details  - update
	public boolean update(Mycart mycart);
	
	
	// get all users   - list
	
	public List<Mycart>     list();
	
	
	//get user details based on userID
	
	public Mycart get(String productId);
	
	
}
