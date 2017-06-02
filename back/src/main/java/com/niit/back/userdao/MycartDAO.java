package com.niit.back.userdao;

import java.util.List;

import com.niit.back.domain.Mycart;

public interface MycartDAO {
	
	
	
	
	// get all users   - list
	
	public List<Mycart>     list();
	
	
	//get user details based on userID
	
	public List<Mycart> getEmail(String email);
public boolean validate(String email, String password);
	
	public void delete(String cartId);

	public boolean save(Mycart mycart);
	
	public Mycart getByProductName(String productName);
	
	public Long getTotal(String cartId);



	public Mycart getByUserandProduct(String email, int productId);


	public boolean itemAlreadyExist(String name, int productId, boolean b);


	public Mycart get(String cartId);

	
	
}
