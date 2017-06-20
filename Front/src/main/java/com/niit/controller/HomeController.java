package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.back.dao.MycartDAO;
import com.niit.back.dao.ProductDAO;
import com.niit.back.dao.UserDAO;
import com.niit.back.domain.Product;
import com.niit.back.domain.User;


@Controller

public class HomeController {
@Autowired
ProductDAO productDAO;
@Autowired
UserDAO userDAO;
@Autowired
MycartDAO mycartDAO;

	@RequestMapping("/")
	public  String    goToHome(Model model){
		
		List<Product> productList = productDAO.list();
		model.addAttribute("productList", productList);
		model.addAttribute("message", "Experience the world class Interiors");
		return "home";
	}


	@RequestMapping("/homePage")
	public String goHome(Model model)

	{
		model.addAttribute("isUserClickedhomePage", "true");
		return "home";
	}
@RequestMapping("/loginPage")
public String loginPage(Model model)
{
	model.addAttribute("isUserClickedLogin", "true");

	return "home";
}
@RequestMapping("/registerPage")
public String registerPage(Model model)
{
	model.addAttribute("isUserClickedSignUp", "true");

	return "home";
}

@RequestMapping("/OrderHistoryPage")
public String OrderHistoryPage(Principal p,Model model) {
	String email = p.getName();
	User user = userDAO.get(email);
	
	
	model.addAttribute("isUserClickedOrderHistory", "true");
	model.addAttribute("mycartList", mycartDAO.listCartByStatus(p.getName(), "P"));
	

	return "home";
}
@RequestMapping("/kitchenPage")
public String kitchen(Model model)
{
	model.addAttribute("isUserClickedKitchen&Dining", "true");

	return "kitchen";
}
@RequestMapping("/servingPage")
public String serving(Model model)
{
	model.addAttribute("isUserClickedDining&Serving", "true");

	return "serving";
}
@RequestMapping("/furniturePage")
public String furniture(Model model)
{
	model.addAttribute("isUserClickedFurniture", "true");

	return "furniture";
}
@RequestMapping("/furnisingPage")
public String furnisingPage(Model model)
{
	model.addAttribute("isUserClickedFurnising", "true");

	return "furnising";
}
@RequestMapping("/automationPage")
public String automationPage(Model model)
{
	model.addAttribute("isUserClickedSmart Home Automation", "true");

	return "automation";
}


@RequestMapping("/ShippingAddressPage")
public String ShippingAddressPage(Model model)
{
	model.addAttribute("isUserClickedShippingAddress", "true");

	return "home";
}
@RequestMapping("/BillingAddressPage")
public String BillingAddressPage(Model model)
{
	model.addAttribute("isUserClickedBillingAddress", "true");

	return "home";
}

}
