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
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public Product findProduct(Long id) {
		Optional<Product> existingProduct = productRepo.findById(id);
		if (existingProduct.isPresent()) {
			return existingProduct.get();
		} else {
			return null;
		}
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> getUsedProducts(Category category) {
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> getUnusedProducts(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
}