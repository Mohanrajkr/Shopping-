package com.niit.back.dao;

import java.util.List;

import com.niit.back.domain.Shippingaddress;

public interface ShippingaddressDAO {
public List<Shippingaddress> list();
	
public List<Shippingaddress> list(String email);	
	public Shippingaddress getByShippingAddress(String address);


	public Shippingaddress getByUserName(String userName);

	public void saveOrUpdate(Shippingaddress address);

	public void delete(int shippingId);
	
	public Shippingaddress getByShippingId(int shippingId);

	

}
