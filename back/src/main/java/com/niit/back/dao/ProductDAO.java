package com.niit.back.dao;

import java.util.List;

import com.niit.back.domain.Product;
public interface ProductDAO {


		public  boolean save(Product product);
		
		// update the user details  - update
	
		
		
		// get all users   - list
		
		public List<Product>     list();
		
		
		//get user details based on userID
		

		
		public void delete(int productId);

		public Product get(int productId);
		public Product get(String productName);
		public boolean saveOrUpdate(Product product);
		
	}


