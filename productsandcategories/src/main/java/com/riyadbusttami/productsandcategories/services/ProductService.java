package com.riyadbusttami.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.riyadbusttami.productsandcategories.models.Product;
import com.riyadbusttami.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	public List<Product> all(){
		return productRepository.findAll();
	}
	
	public Product create(Product product) {
		return productRepository.save(product);
	}
	
	public Product get(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
	public void delete(Product product) {
		productRepository.delete(product);
	}

}
