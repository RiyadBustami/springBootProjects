package com.riyadbusttami.dojoninjasassignment.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.riyadbusttami.dojoninjasassignment.models.Dojo;
import com.riyadbusttami.dojoninjasassignment.services.DojoService;

@Controller
public class DojoController {
	private DojoService dojoService;
	public DojoController(DojoService dojoService) {
		this.dojoService=dojoService;
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "/dojo/new.jsp";
	}
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojo/new.jsp";
		}
		else {
			return "redirect:/dojos/"+dojoService.create(dojo).getId();
		}
	}
	@GetMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo",dojoService.get(id));
		return "/dojo/show.jsp";
	}
}
