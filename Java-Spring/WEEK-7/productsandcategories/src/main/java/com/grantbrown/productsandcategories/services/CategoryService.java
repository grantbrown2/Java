package com.grantbrown.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grantbrown.productsandcategories.models.Category;
import com.grantbrown.productsandcategories.models.Product;
import com.grantbrown.productsandcategories.repositories.CategoryRepository;
import com.grantbrown.productsandcategories.repositories.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	public Category findCategory(Long id) {
		Optional<Category> existingCategory = categoryRepo.findById(id);
		if (existingCategory.isPresent()) {
			return existingCategory.get();
		} else {
			return null;
		}
	}
	
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public List<Category> getUsedCateories(Product product) {
		return categoryRepo.findAllByProducts(product);
	}

	public List<Category> getUnusedCategories(Product product) {
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
}
