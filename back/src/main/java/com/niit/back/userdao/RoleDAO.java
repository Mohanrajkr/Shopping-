package com.niit.back.userdao;

import java.util.List;

import com.niit.back.domain.Role;

public interface RoleDAO {
	public boolean save(Role role);

	// get all users - list

	public List<Role> list();

	public Role get(String email);

}
