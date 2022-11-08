package com.riyadbusttami.productsandcategories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.riyadbusttami.productsandcategories.services.CategoryService;
import com.riyadbusttami.productsandcategories.services.ProductService;

@Controller
public class MainController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public MainController(ProductService productService, CategoryService categoryService) {
		this.productService=productService;
		this.categoryService=categoryService;
	}
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categories",categoryService.all());
		model.addAttribute("products",productService.all());
		return "index.jsp";
	}

}
