package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class HomeController {
	@RequestMapping("/")
	public  String    goToHome(Model model){
		model.addAttribute("message", "Experience the world class Interiors");
		return "home";
	}


@RequestMapping("/loginPage")
public String loginPage(Model model)
{
	model.addAttribute("isUserClickedLogin", "true");

	return "login";
}
@RequestMapping("/registerPage")
public String registerPage(Model model)
{
	model.addAttribute("isUserClickedSignUp", "true");

	return "register";
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
}
