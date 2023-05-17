package com.grantbrown.productsandcategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grantbrown.productsandcategories.models.Category;
import com.grantbrown.productsandcategories.models.Product;
import com.grantbrown.productsandcategories.services.CategoryService;
import com.grantbrown.productsandcategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	@Autowired
	ProductService productServ;
	
	@Autowired
	CategoryService categoryServ;
	
	@GetMapping("/categories/new")
	public String categoryAddForm(
			@ModelAttribute("category") Category category,
			Model viewmodel) {
		viewmodel.addAttribute("category", category);
		return "new-category.jsp";
	}
	
	@PostMapping("/categories/create")
	public String createCategory(
			@Valid @ModelAttribute("category") Category category,
			BindingResult result,
			Model viewmodel) {
		if (result.hasErrors()) {
			List<Category> categories = categoryServ.allCategories();
			viewmodel.addAttribute(categories);
			return "new-category.jsp";
		}
		categoryServ.createCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model viewmodel) {
		Category category = categoryServ.findCategory(id);
		viewmodel.addAttribute("category", category);
		
		viewmodel.addAttribute("usedProducts", productServ.getUsedProducts(category));
		viewmodel.addAttribute("unusedProducts", productServ.getUnusedProducts(category));
		
		return "show-categories.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String addProductToCategory(
			@PathVariable("id") Long id,
			@RequestParam("productId") Long productId,
			Model viewmodel) {
		Category existingCategory = categoryServ.findCategory(id);
		if (existingCategory != null) {
			Product selectedProducts = productServ.findProduct(productId);
			if (selectedProducts != null) {
				existingCategory.getProducts().add(selectedProducts);
				categoryServ .createCategory(existingCategory);
				return "redirect:/categories/" + id;
			}
		}
		return "redirect:/products";
	}
}
