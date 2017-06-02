package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.back.domain.Category;
import com.niit.back.domain.Product;
import com.niit.back.domain.Supplier;
import com.niit.back.userdao.CategoryDAO;
import com.niit.back.userdao.ProductDAO;
import com.niit.back.userdao.SupplierDAO;
import com.niit.front.util.FileUtil;
@Controller
public class ProductController {
	@Autowired 
	 private SupplierDAO supplierDAO;
	@Autowired 
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@RequestMapping("newProduct")
	public String newProduct(@ModelAttribute Product product,@RequestParam("image")MultipartFile file, Model model) {
		productDAO.save(product);
		String path="D://workspace/Front/src/main/webapp/WEB-INF/resources/images/product/";
		FileUtil.upload(path, file, product.getProductId()+".jpg");
		return "redirect:/viewproductPage";
	}
	@RequestMapping("/ProductPage")
	public String productPage(Model model)
	{
		List<Supplier> SupplierList = supplierDAO.list();
		List<Category> CategoryList = categoryDAO.list();
		model.addAttribute("SupplierList",SupplierList);
		model.addAttribute("CategoryList",CategoryList);
		model.addAttribute("isAdminClickedAddProduct", "true");

		return "adminlogin";
	}
	@RequestMapping("/viewproductPage")
	public String viewproductPage(Model model)
	{
		List<Product> productList = productDAO.list();
		model.addAttribute("productList", productList);
		model.addAttribute("isAdminClickedViewProduct", "true");
        return "adminlogin";
	}
	
	@RequestMapping("deleteProduct")
	public String deleteProduct(@RequestParam(value = "productId") int productId) {

		productDAO.delete(productId);
		return "redirect:/viewproductPage";

	}

	@RequestMapping("editProduct")
	public String editProduct(@RequestParam(value = "productId") int productId, Model model) {

		Product product = productDAO.get(productId);
		model.addAttribute("product", product);
		model.addAttribute("isAdminClickedEditProduct", "true");

		return "adminlogin";

	}
	
	@RequestMapping("afterEditProduct")
	public String afterEditProduct(@ModelAttribute Product product, Model model ){
		productDAO.saveOrUpdate(product);
		
		return "redirect:/viewproductPage";
	}


	@ModelAttribute
	public void adminProduct(Model model) {

		model.addAttribute("isAdmin", "true");
	}
}
