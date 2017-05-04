package com.niit.back.userdao;

import java.util.List;

import com.niit.back.domain.Role;

public interface RoleDAO {
public  boolean save(Role role);
	
	// update the user details  - update
	public boolean update(Role role);
	
	
	// get all users   - list
	
	public List<Role>     list();
	
	
}
