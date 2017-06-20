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

import com.niit.back.dao.MycartDAO;
import com.niit.back.dao.ProductDAO;
import com.niit.back.dao.UserDAO;
import com.niit.back.domain.Mycart;
import com.niit.back.domain.Product;
import com.niit.back.domain.User;

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
		Long GrandTotal = mycartDAO.getTotal(email);
		model.addAttribute("GrandTotal", GrandTotal);
		model.addAttribute("mycartList", mycartDAO.listCartByStatus(email, "N"));
		model.addAttribute("isUserClickedAddtocart", true);
		if (mycartDAO.listCartByStatus(email, "N").isEmpty())
			model.addAttribute("ismycartEmpty", true);
		else
			model.addAttribute("ismycartEmpty", false);

		return "userlogin";
	}

	@RequestMapping("addtocart")
	public String addtocart(@RequestParam("productId") int productId, Principal p, Model model) {

		Product product = productDAO.get(productId);
		String productName=product.getProductName();
		User user = userDAO.get(p.getName());
		Mycart crt = mycartDAO.getByUserandProduct(p.getName(), productName);

		if (product.getQuantity() > 0) {

			if (mycartDAO.itemAlreadyExist(user.getEmail(),productName)!=null) {
	
				int qty = crt.getQuantity() + 1;
				crt.setQuantity(qty);
				crt.setTotal(product.getPrize() * qty);
				boolean flag = mycartDAO.update(crt);
				System.out.println(flag);
				System.out.println(qty);
				
			} else {

				Random t = new Random();
				int day = 2 + t.nextInt(7);

				// List<Mycart> mycartList = mycartDAO.list();
				// model.addAttribute("mycartList", mycartList);

				mycart.setEmail(p.getName());
				mycart.setPrize(product.getPrize());
				mycart.setProductId(product.getProductId());
				mycart.setUserId(p.getName());
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
		} else {
			model.addAttribute("product", product);
			model.addAttribute("productDescription", true);
			model.addAttribute("message", "Out of stock");
			return "userlogin";
		}

	}

	/*
	 * @RequestMapping("/mycart/addQuantity/{productId}") public String
	 * updateQuantity(@PathVariable("productId") int cartId, Principal p) {
	 * 
	 * User user = userDAO.get(p.getName());
	 * 
	 * mycart = mycartDAO.get(cartId); int presentQuantity =
	 * mycartDAO.getQuantity(user.getUserId(), mycart.getProductName());
	 * mycart.setQuantity(presentQuantity + 1); mycartDAO.update(mycart); int
	 * productId = mycart.getProductId(); Product pct =
	 * productDAO.get(productId); int qty = pct.getQuantity() - 1;
	 * pct.setQuantity(qty); productDAO.saveOrUpdate(pct); return
	 * "redirect:/mycartlistPage"; }
	 */

	/*
	 * @RequestMapping("/mycart/reduceQuantity/{productId}") public String
	 * reduceQuantity(@PathVariable("productId") int cartId) { //int
	 * loggedInUserid = (int) session.getAttribute("loggedInUserID"); mycart =
	 * mycartDAO.get(cartId); int presentQuantity =
	 * mycartDAO.getQuantity(loggedInUserid, mycart.getProductName()); if
	 * (presentQuantity == 1) { session.setAttribute("isQuantityOne", "true");
	 * session.setAttribute("productMessage",
	 * "Remove product by clicking the delete button"); return
	 * "redirect:/mycartlistPage"; } mycart.setQuantity(presentQuantity - 1);
	 * mycartDAO.update(mycart); int productId = mycart.getProductId(); Product
	 * product = productDAO.get(productId); int qty = product.getQuantity() + 1;
	 * product.setQuantity(qty); productDAO.saveOrUpdate(product); return
	 * "redirect:/mycartlistPage"; }
	 */
	@RequestMapping("removecart")
	public String removecart(@RequestParam("cartId") int cartId, Model model) {

		Mycart mycart = mycartDAO.get(cartId);
		Product product = productDAO.get(mycart.getProductId());

		int qty = product.getQuantity() + mycart.getQuantity();

		product.setQuantity(qty);
		productDAO.saveOrUpdate(product);

		mycartDAO.delete(cartId);
		return "redirect:mycartlistpage";
	}

	@ModelAttribute
	public void commonToUser(Model model) {
		model.addAttribute("isUser", true);
	}

}
