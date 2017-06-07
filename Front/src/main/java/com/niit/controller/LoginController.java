package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.back.dao.RoleDAO;
import com.niit.back.dao.UserDAO;
import com.niit.back.domain.Role;

public class LoginController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private Role role;

	/*@RequestMapping("signIn")
	public String showMessage(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password, Model model) {
		System.out.println("in controller");
		// String message;
		String mess;
		if (userDAO.validate(email, password)) {

			role = roleDAO.get(email);
			String u = "ROLE_USER";
			//String admin = "ROLE_ADMIN";
			String r = role.getRole();
			System.out.println(r);

			if (r.equals(u)) {
				mess = "userlogin";
			} 
			else {
				mess = "adminlogin";
			}
			model.addAttribute("message", "Valid Credentials");
			model.addAttribute("email", email);
			return mess;
		} else {

			model.addAttribute("message", "Invalid Credentials");
			mess = "home";
			
		}
		return mess;
	}*/
}
