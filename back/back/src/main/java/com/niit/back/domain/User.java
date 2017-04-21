package com.niit.back.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="user")
public class User {
	@Id
	private String userid;
	
private String username;
private String password;
private String Mobilenumber;
private String Address;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobilenumber() {
	return Mobilenumber;
}
public void setMobilenumber(String mobilenumber) {
	Mobilenumber = mobilenumber;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}



}
