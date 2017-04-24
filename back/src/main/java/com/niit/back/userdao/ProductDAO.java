package com.niit.back.userdao;

import java.util.List;

import com.niit.back.domain.Product;
public interface ProductDAO {


		public  boolean save(Product product);
		
		// update the user details  - update
		public boolean update(Product product);
		
		
		// get all users   - list
		
		public List<Product>     list();
		
		
		//get user details based on userID
		
		public Product get(String productId);
		
		
		
	}


