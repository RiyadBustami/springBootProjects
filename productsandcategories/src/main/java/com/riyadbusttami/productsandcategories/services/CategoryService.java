package com.riyadbusttami.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.riyadbusttami.productsandcategories.models.Category;
import com.riyadbusttami.productsandcategories.models.Product;
import com.riyadbusttami.productsandcategories.repositories.CategoryRepository;
@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}
	
	public List<Category> all(){
		return categoryRepository.findAll();
	}
	
	public Category get(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else {
			return null;
		}
	}
	
	public Category create(Category category) {
		return categoryRepository.save(category);
	}
	
	public void delete(Category category) {
		categoryRepository.delete(category);
	}
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}
	
	public Category update(Category category) {
		return categoryRepository.save(category);
	}
	public List<Category> getAllNot(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
}
