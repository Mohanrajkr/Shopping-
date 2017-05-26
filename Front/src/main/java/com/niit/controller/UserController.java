package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.back.domain.Product;
import com.niit.back.domain.Role;
import com.niit.back.domain.User;
import com.niit.back.userdao.ProductDAO;
import com.niit.back.userdao.RoleDAO;
import com.niit.back.userdao.UserDAO;

@Controller
public class UserController {
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private Role role;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("newUser")
	public String newUser(@ModelAttribute User user, Model model) {

		role.setRole("ROLE_USER");
		role.setUserName(user.getUserName());
		role.setEmail(user.getEmail());
		user.setEnabled(true);

		user.setRole(role);
		role.setUser(user);

		userDAO.save(user);
		roleDAO.save(role);

		model.addAttribute("isUserClickedLogin", "true");
		return "home";

	}

	@RequestMapping("/afterlogin")
	public String afterlogin(Principal p, Model model) {
		String email = p.getName();
		System.out.println(email);
		User user = userDAO.get(email);
		Role role = roleDAO.get(email);

		String validator = role.getRole();
		System.out.println(validator);
		if (validator.equals("ROLE_ADMIN")){
			model.addAttribute("isAdmin", "true");
			return "adminlogin";

		} 
		else if (validator.equals("ROLE_USER")) {
			
			List<Product> productList = productDAO.list();
			model.addAttribute("productList", productList);
			model.addAttribute("isUser", "true");
			return "userlogin";

		} 
		else {
			return "home";
		}
	}

}
