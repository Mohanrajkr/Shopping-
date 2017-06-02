package com.niit.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@Autowired
	private Mycart mycart;

	@RequestMapping("productDescription")
	public String productDescription(@RequestParam("productId") int productId, Model model) {

		Product product = productDAO.get(productId);

		model.addAttribute("productDescription", "true");
		model.addAttribute("product", product);
		return "userlogin";
	}

	@RequestMapping("/mycartlistpage")
	public String mycartlistpage(Principal p, Model model) {
		String email = p.getName();
		User user = userDAO.get(email);
		List<Mycart> mycartList = mycartDAO.getEmail(email);

		model.addAttribute("mycartList", mycartList);
		model.addAttribute("isUserClickedAddtocart", true);

		return "userlogin";
	}

	@RequestMapping("addtocart")
	public String addtocart(@RequestParam("productId") int productId, Principal p, Model model) {

		Product product = productDAO.get(productId);
		User user = userDAO.get(p.getName());
		Mycart crt = mycartDAO.getByUserandProduct(p.getName(), productId);

		if (product.getQuantity() > 0) {

			if (mycartDAO.itemAlreadyExist(p.getName(), productId, true)) {
				int qty = crt.getQuantity() + 1;
				crt.setQuantity(qty);
				crt.setTotal(product.getPrize() * qty);
				boolean flag = mycartDAO.save(crt);
				System.out.println(flag);
				System.out.println(qty);
			} else {

				Random t = new Random();
				int day = 2 + t.nextInt(7);

				//List<Mycart> mycartList = mycartDAO.list();
				//model.addAttribute("mycartList", mycartList);
		
				mycart.setEmail(p.getName());
				mycart.setPrize(product.getPrize());
				mycart.setProductName(product.getProductName());
				mycart.setQuantity(1);
				mycart.setStatus("N");
				mycart.setDays(day);
			
				mycart.setTotal(product.getPrize() * mycart.getQuantity());
				// List<Mycart> mycartList = mycartDAO.getEmail(p.getName());
				Long currentTime = System.currentTimeMillis();
				Date currentDate = new Date(currentTime);
				mycart.setDate(currentDate);
				boolean flag = mycartDAO.save(mycart);
				System.out.println(flag);
				

			}
			int qty = product.getQuantity() - 1;
			product.setQuantity(qty);

			productDAO.saveOrUpdate(product);

			return "redirect:mycartlistpage";
		}
		else 
		{
			model.addAttribute("product", product);
			model.addAttribute("productDescription", true);
			model.addAttribute("message", "Out of stock");
			return "userlogin";
		}

	}
	
	@RequestMapping("removecart")
	public String removecart(@RequestParam("cartId") String cartId, Model model) {
		
		Mycart mycart = mycartDAO.get(cartId);
		Product product = productDAO.get(mycart.getProductId());
		
		int qty = product.getQuantity() + mycart.getQuantity();
		
		product.setQuantity(qty);
		productDAO.saveOrUpdate(product);
		
		mycartDAO.delete(cartId);
		return "redirect:mycartlistPage";
	}
	@ModelAttribute
	public void commonToUser(Model model){
		model.addAttribute("isUser", true);
	}
	

}
