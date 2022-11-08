package com.riyadbusttami.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riyadbusttami.productsandcategories.models.Category;
import com.riyadbusttami.productsandcategories.models.Product;
import com.riyadbusttami.productsandcategories.services.CategoryService;
import com.riyadbusttami.productsandcategories.services.ProductService;
@Controller
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductController(ProductService productService,CategoryService categoryService) {
		this.productService=productService;
		this.categoryService=categoryService;
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
	@GetMapping("/products/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		Product product=productService.get(id);
		model.addAttribute("product", product);
		model.addAttribute("categories",categoryService.getAllNot(product));
		return "/products/show.jsp";
		
		
	}
	@PostMapping("/products/{id}")
	public String add(@RequestParam("selectedCategory")Long selectedCategoryId, @PathVariable("id")Long id) {
		
		Product prod=productService.get(id);
		Category cat=categoryService.get(selectedCategoryId);
		List<Category> prodCats=prod.getCategories();
		prodCats.add(cat);
		prod.setCategories(prodCats);
		productService.update(prod);
		
		
		return "redirect:/products/"+id;
		
	}
	
}
