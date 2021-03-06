package com.niit.controller;

import java.security.Principal;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.niit.back.dao.ProductDAO;
import com.niit.back.dao.RoleDAO;
import com.niit.back.dao.ShippingaddressDAO;
import com.niit.back.dao.UserDAO;
import com.niit.back.domain.Product;
import com.niit.back.domain.Role;
import com.niit.back.domain.Shippingaddress;
import com.niit.back.domain.User;

@Controller
public class UserController {
	@Autowired
	private ShippingaddressDAO shippingaddressDAO;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private Role role;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("newUser")
	public String newUser(@ModelAttribute User user,@ModelAttribute Shippingaddress shippingaddress, Model model) {
String message;
	
		
		if(userDAO.isAllReadyRegister(user.getEmail(), true) && userDAO.isAllReadyRegisterMobileNumber(user.getMobileNumber(), true)){		
			
			message = "Your EmailId and Contact All Ready Registered";
		} else if (userDAO.isAllReadyRegister(user.getEmail(), true)) {
			message = "Your Email Id All Ready Registered";
		}else if (userDAO.isAllReadyRegisterMobileNumber(user.getMobileNumber(), true)) {
			message = "Your Mobile Number All Ready Registered";
		}
		else{
		role.setRole("ROLE_USER");
		role.setUserName(user.getUserName());
		role.setEmail(user.getEmail());
		user.setEnabled(true);

		user.setRole(role);
		role.setUser(user);

		userDAO.save(user);
		
		roleDAO.save(role);
		
		shippingaddress.setEmail(user.getEmail());
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		message = "Your Have Successfully Registered";
		}
		model.addAttribute("message", message);
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
