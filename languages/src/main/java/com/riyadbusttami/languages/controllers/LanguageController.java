package com.riyadbusttami.languages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.riyadbusttami.languages.models.Language;
import com.riyadbusttami.languages.services.LanguageService;


@Controller
public class LanguageController {

	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService=languageService;
	}
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("language")Language language, Model model) {
		model.addAttribute("languages",languageService.allLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@ModelAttribute("language")Language language,BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			languageService.createLanguage(language);	
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id")Long id,Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
		return "show.jsp";
	}
	
	@GetMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id")Long id,Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
		return "edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String update(@ModelAttribute("language")Language language,BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			languageService.updateLanguage(language);
			
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("languages/{id}")
	public String delete(@PathVariable("id")Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}

}
