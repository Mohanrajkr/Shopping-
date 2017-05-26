package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.back.domain.Category;
import com.niit.back.domain.Supplier;
import com.niit.back.userdao.CategoryDAO;
import com.niit.back.userdao.SupplierDAO;
@Controller
public class SupplierController {
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping("newSupplier")
	public String newSupplier(@ModelAttribute Supplier supplier, Model model) {
		supplierDAO.save(supplier);
		
		return "redirect:/viewsupplierPage";
	}
	@RequestMapping("/SupplierPage")
	public String supplierPage(Model model)
	{
		model.addAttribute("isAdminClickedAddSupplier", "true");

		return "adminlogin";
	}
	@RequestMapping("/viewsupplierPage")
	public String viewsupplierPage(Model model)
	{
		List<Supplier> supplierList = supplierDAO.list();
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("isAdminClickedViewSupplier", "true");

		return "adminlogin";
	}
	
	@RequestMapping("deleteSupplier")
	public String deleteSupplier(@RequestParam(value = "supplierId") String supplierId) {

		supplierDAO.delete(supplierId);
		return "redirect:/viewsupplierPage";

	}

	@RequestMapping("editSupplier")
	public String editSupplier(@RequestParam(value = "supplierId") String supplierId, Model model) {

		Supplier supplier = supplierDAO.get(supplierId);
		model.addAttribute("supplier", supplier);
		model.addAttribute("isAdminClickedEditSupplier", "true");

		return "adminlogin";

	}
	
	@RequestMapping("afterEditSupplier")
	public String afterEditSupplier(@ModelAttribute Supplier supplier, Model model ){
		supplierDAO.update(supplier);
		
		return "redirect:/viewsupplierPage";
	}

	@ModelAttribute
	public void adminSupplier(Model model) {

		model.addAttribute("isAdmin", "true");
	}
}
