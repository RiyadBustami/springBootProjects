package com.riyadbusttami.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riyadbusttami.productsandcategories.models.Category;
import com.riyadbusttami.productsandcategories.models.Product;
import com.riyadbusttami.productsandcategories.services.CategoryService;
import com.riyadbusttami.productsandcategories.services.ProductService;
@Controller
public class CategoryController {

	private final CategoryService categoryService;
	private final ProductService productService;
	public CategoryController(CategoryService categoryService,ProductService productService) {
		this.categoryService=categoryService;
		this.productService=productService;
	}
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category")Category category) {
		return "/categories/new.jsp";
	}

	@PostMapping("/categories")
	public String create(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		}
		else {
			categoryService.create(category);
			return "redirect:/categories/new";
		}
	}
	@GetMapping("/categories/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		Category category=categoryService.get(id);
		model.addAttribute("category", category);
		model.addAttribute("products",productService.getAllNot(category));
		return "/categories/show.jsp";
		
		
	}
	@PostMapping("/categories/{id}")
	public String add(@RequestParam("selectedProduct")Long selectedProductId, @PathVariable("id")Long id) {
		
		Category cat=categoryService.get(id);
		Product prod=productService.get(selectedProductId);
		List<Product> catProds=cat.getProducts();
		catProds.add(prod);
		cat.setProducts(catProds);
		categoryService.update(cat);
		
		
		return "redirect:/categories/"+id;
		
	}
	
	
	
}
