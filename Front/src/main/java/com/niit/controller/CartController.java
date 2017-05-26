package com.niit.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.niit.back.domain.Mycart;
import com.niit.back.domain.Product;
import com.niit.back.domain.User;
import com.niit.back.userdao.MycartDAO;
import com.niit.back.userdao.ProductDAO;
import com.niit.back.userdao.UserDAO;

@Controller
public class CartController {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private MycartDAO mycartDAO;
	@Autowired private Mycart mycart;
	
@RequestMapping("productDescription")
public String productDescription(@RequestParam("productId")String productId,Model model){
	
	Product product=productDAO.get(productId);
	
	model.addAttribute("productDescription","true");
	model.addAttribute("product", product);
	return "userlogin";
}



@RequestMapping("/mycartlistpage")
public String mycartlistpage(Principal p,Model model)
{
	String email = p.getName();
	User user = userDAO.get(email);
	List<Mycart> mycartList =  mycartDAO.getEmail(email);
	Long GrandTotal =mycartDAO.getTotal(user.getUserId()); 
	
	model.addAttribute("GrandTotal ",GrandTotal );
	model.addAttribute("mycartList",mycartList);
	model.addAttribute("isUserClickedAddtocart", true);

	return "userlogin";
}

@RequestMapping("addtocart")
public String addtocart(@RequestParam("productId") String productId, Principal p, Model model){
	
	Product product = productDAO.get(productId);		
	User user = userDAO.get(p.getName());		
	//Mycart mycart = mycartDAO.getByUserandProduct(p.getName(), productId);
	List<Mycart> mycartList=mycartDAO.list();
	model.addAttribute("mycartList", mycartList);
	mycart.setProductId(productId);
	mycart.setEmail(p.getName());
	mycart.setPrize(product.getPrize());
	mycart.setProductName(product.getProductName());
	mycart.setQuantity(1);
	mycart.setStatus("N");
	mycart.setDays(1);
	mycart.setUserId(user.getUserId());
	mycart.setTotal(product.getPrize()*1);
	/*List<Mycart> mycartList =  mycartDAO.getEmail(p.getName());*/
	Long currentTime=System.currentTimeMillis();
	Date currentDate=new Date(currentTime);
	mycart.setDate(currentDate);

	mycartDAO.saveOrUpdate(mycart);
	
	model.addAttribute("isUserClickedMoreInfo", true);
	model.addAttribute("isUserClickedAddtocart", true);
		return "userlogin";
	}



}
