package com.niit.back.dao;

import java.util.List;

import com.niit.back.domain.Mycart;

public interface MycartDAO {
	
	
	
	
	// get all users   - list
	
	public List<Mycart>     list();
	
	
	//get user details based on userID
	
	public List<Mycart> getEmail(String email);
public boolean validate(String email, String password);
	
	public void delete(int cartId);

	public boolean save(Mycart mycart);
	public boolean update(Mycart mycart);
	public Mycart getByProductName(String productName);
	
	public Long getTotal(String cartId);



	public Mycart getByUserandProduct(String email, int productId);


	public boolean itemAlreadyExist(String email, int productId);


	public Mycart get(int cartId);


	public void updateshipping(String email, int shippingId);

	public Integer getQuantity(String userId, String productName);
	
}
