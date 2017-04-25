package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.back.domain.Category;
import com.niit.back.domain.Product;
import com.niit.back.domain.Supplier;
import com.niit.back.domain.User;
import com.niit.back.userdao.CategoryDAO;
import com.niit.back.userdao.ProductDAO;
import com.niit.back.userdao.SupplierDAO;
import com.niit.back.userdao.UserDAO;

@Controller
public class UserController 
{
	
		@Autowired
		private UserDAO userDAO;
		
		@RequestMapping("newUser")
		public String newUser(@ModelAttribute User user, Model model){
			userDAO.save(user);
			model.addAttribute("isUserClickedSignUp", "true");
			return "home";
}
		@Autowired
		private CategoryDAO categoryDAO;
		
		@RequestMapping("newCategory")
		public String newCategory(@ModelAttribute Category category, Model model){
			categoryDAO.save(category);
			model.addAttribute("isUserClickedNewCategory", "true");
			return "home";
		}
		@Autowired
		private SupplierDAO supplierDAO;
		
		@RequestMapping("newSupplier")
		public String newSupplier(@ModelAttribute Supplier supplier, Model model){
			supplierDAO.save(supplier);
			model.addAttribute("isUserClickedSupplier", "true");
			return "home";
		}
		@Autowired
		private ProductDAO productDAO;
		
		@RequestMapping("newProduct")
		public String newProduct(@ModelAttribute Product product, Model model){
			productDAO.save(product);
			model.addAttribute("isUserClickedProduct", "true");
			return "home";
		}
}
