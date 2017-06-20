package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.back.dao.MycartDAO;
import com.niit.back.dao.ShippingaddressDAO;
import com.niit.back.dao.UserDAO;
import com.niit.back.domain.Mycart;
import com.niit.back.domain.Shippingaddress;
import com.niit.back.domain.User;

@Controller
public class ShippingaddressController {
	@Autowired
	private ShippingaddressDAO shippingaddressDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private MycartDAO mycartDAO;
	@Autowired
	private Mycart mycart;
	
	@RequestMapping("shippingaddressPage")
	public ModelAndView newShippingaddress(){
		
		ModelAndView mv = new ModelAndView("userlogin");
		mv.addObject("newShippingaddressClicked", "true");
		return mv;
	}
	@RequestMapping("proceed")
	public String Proceed(Principal p, Model model){
		String email = 	p.getName();
		List<Shippingaddress> shippingaddressList = shippingaddressDAO.list(email);
		model.addAttribute("shippingaddressList", shippingaddressList);
		model.addAttribute("isUserClickedShippingaddress", true);
		
	 return "userlogin";
	}
	@RequestMapping("addShippingaddress")
	public String addShippingaddress(Principal p, @ModelAttribute Shippingaddress shippingaddress){
		User user = userDAO.get(p.getName());
		
		shippingaddress.setEmail(p.getName());		
	    shippingaddressDAO.saveOrUpdate(shippingaddress);
		return "redirect:proceed";
		
	}
	@RequestMapping("shippingAddress")
	public String shippingAddress(@RequestParam("shippingId") int shippingId, Principal p, Model model){
		
		String email = p.getName();
		
		List<Mycart> mycartList = mycartDAO.getEmail(email);
		
		for(Mycart m : mycartList){
			m.setShippingId(shippingId);
			mycartDAO.save(m);
		}
		model.addAttribute("DeliverHereClicked", true);
		model.addAttribute("thankyouPage", true);
		return "userlogin";
		
	}
	@RequestMapping("deleteshippingAddress")
	public String deleteshippingAddress(@RequestParam("shippingId") int shippingId, Model model){
		shippingaddressDAO.delete(shippingId);
		return "redirect:proceed";
		
	}
	@RequestMapping("editshippingAddress")
	public String editshippingAddress(@RequestParam("shippingId")int shippingId,Model model){
	Shippingaddress shippingaddress=shippingaddressDAO.getByShippingId(shippingId);
		model.addAttribute("shippingaddress", shippingaddress);
		model.addAttribute("editShippingAddressClicked", true);
		return "userlogin";
		
	}
	@RequestMapping("editShippingaddress")
	public String editShippingAddress(Principal p, @ModelAttribute Shippingaddress shippingaddress, Model model){
		
		String email = p.getName();
		User user = userDAO.get(email);
		
		shippingaddress.setEmail(email);
		shippingaddress.setUserName(user.getEmail());
		
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		return "redirect:proceed";
	}
	
	@RequestMapping("thankyouPage")
	public String thankyouPage( Principal p,Model model){
		String email = p.getName();
		User user = userDAO.get(email);
		for(Mycart mycart : mycartDAO.listCartByStatus(email, "N")){
			mycart.setStatus("P");
			mycart.setProductName(mycart.getProductName()+" ");
			mycartDAO.update(mycart);
		}
		model.addAttribute("CheckoutClicked", true);
		return "userlogin";
	}
	@ModelAttribute
	public void commonToUser(Model model){
		model.addAttribute("isUser", "true");
	}
	
	}
