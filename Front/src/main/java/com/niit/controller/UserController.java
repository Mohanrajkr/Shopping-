package com.niit.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.niit.back.domain.Role;
import com.niit.back.domain.User;
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
	
	@RequestMapping("newUser")
	public String newUser(@ModelAttribute User user, Model model) {

		role.setRole("ROLE_USER");
		role.setUserName(user.getUserName());
		role.setEmail(user.getEmail());
		user.setEnable(true);

		user.setRole(role);
		role.setUser(user);

		userDAO.save(user);
		roleDAO.save(role);

		model.addAttribute("isUserClickedLogin", "true");
		return "home";

	}

	
	


}
