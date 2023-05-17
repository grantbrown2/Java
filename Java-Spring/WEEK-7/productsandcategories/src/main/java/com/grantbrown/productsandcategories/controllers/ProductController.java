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
public class ProductController {
	@Autowired
	ProductService productServ;
	
	@Autowired
	CategoryService categoryServ;
	
	@GetMapping("/")
	public String home(
			@ModelAttribute("product") Product product,
			Model viewmodel) {
		List<Product> products = productServ.allProducts();
		List<Category> categories = categoryServ.allCategories();
		viewmodel.addAttribute("products", products);
		viewmodel.addAttribute("categories", categories);
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String productAddform(
			@ModelAttribute("product") Product product,
			Model viewmodel) {
		viewmodel.addAttribute("product", product);
		return "new-product.jsp";
	}
	
	@PostMapping("/products/create")
	public String createProduct(
			@Valid @ModelAttribute("product") Product product,
			BindingResult result,
			Model viewmodel) {
		if (result.hasErrors()) {
			List<Product> products = productServ.allProducts();
			viewmodel.addAttribute(products);
			return "new-product.jsp";
		}
		productServ.createProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model viewmodel) {
		Product product = productServ.findProduct(id);
		viewmodel.addAttribute("product", product);
		
		viewmodel.addAttribute("usedCategories", categoryServ.getUsedCateories(product));
		viewmodel.addAttribute("unusedCategories", categoryServ.getUnusedCategories(product));
		
		return "show-product.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String addCategoryToProduct(
			@PathVariable("id") Long id,
			@RequestParam("categoryId") Long categoryId,
			Model viewmodel) {
		Product existingProduct = productServ.findProduct(id);
		if (existingProduct != null) {
			Category selectedCategories = categoryServ.findCategory(categoryId);
			if (selectedCategories != null) {
				existingProduct.getCategories().add(selectedCategories);
				productServ.createProduct(existingProduct);
				return "redirect:/products/" + id;
			}
		}
		return "redirect:/products";
	}
}
