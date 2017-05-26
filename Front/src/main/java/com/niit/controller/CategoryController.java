 package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.back.domain.Category;
import com.niit.back.userdao.CategoryDAO;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping("newCategory")
	public String newCategory(@ModelAttribute Category categoty, Model model) {
		categoryDAO.save(categoty);
		
		return "redirect:/viewcategoryPage";
	}

	@RequestMapping("/CategoryPage")
	public String categoryPage(Model model) {

		model.addAttribute("isAdminClickedAddCategory", "true");
		return "adminlogin";

	}

	@RequestMapping("/viewcategoryPage")
	public String viewcategoryPage(Model model) {
		List<Category> categoryList = categoryDAO.list();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("isAdminClickedViewCategory", "true");

		return "adminlogin";
	}

	@RequestMapping("deleteCategory")
	public String deleteCategory(@RequestParam(value = "categoryId") String categoryId) {

		categoryDAO.delete(categoryId);
		return "redirect:/viewcategoryPage";

	}

	@RequestMapping("editCategory")
	public String editCategory(@RequestParam(value = "categoryId") String categoryId, Model model) {

		Category category = categoryDAO.get(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("isAdminClickedEditCategory", "true");

		return "adminlogin";

	}
	
	@RequestMapping("afterEditCategory")
	public String afterEditCategory(@ModelAttribute Category categoty, Model model ){
		categoryDAO.update(categoty);
		
		return "redirect:/viewcategoryPage";
	}

	@ModelAttribute
	public void adminCategory(Model model) {

		model.addAttribute("isAdmin", "true");
	}
}
