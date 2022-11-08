package com.riyadbusttami.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.riyadbusttami.productsandcategories.models.Category;
import com.riyadbusttami.productsandcategories.services.CategoryService;
@Controller
public class CategoryController {

	private final CategoryService categoryService;
	public CategoryController(CategoryService categoryService) {
		this.categoryService=categoryService;
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
	
}
