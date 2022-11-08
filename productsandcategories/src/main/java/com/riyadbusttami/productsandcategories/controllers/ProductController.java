package com.riyadbusttami.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.riyadbusttami.productsandcategories.models.Product;
import com.riyadbusttami.productsandcategories.services.ProductService;
@Controller
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product")Product product) {
			return "/products/new.jsp";
	}
	
	@PostMapping("/products")
	public String create(@Valid @ModelAttribute("product")Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		}
		else {
			productService.create(product);
			return "redirect:/products/new";
		}
	}
//	
//	@GetMapping("/products/{id}")
//	public String show(@PathVariable("id")Long id, Model model) {
//		return "/products/show.jsp";
//	}
//	
//	@PostMapping("/products/")

}
