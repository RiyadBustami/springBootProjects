package com.riyadbusttami.dojoninjasassignment.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.riyadbusttami.dojoninjasassignment.models.Ninja;
import com.riyadbusttami.dojoninjasassignment.services.DojoService;
import com.riyadbusttami.dojoninjasassignment.services.NinjaService;

@Controller
public class NinjaController {
	DojoService dojoService;
	NinjaService ninjaService;
	public NinjaController(DojoService dojoService,NinjaService ninjaService) {
		this.ninjaService=ninjaService;
		this.dojoService=dojoService;
	}
	@GetMapping("/ninjas/new")
	public String index(Model model,@ModelAttribute("ninja")Ninja ninja) {
		model.addAttribute("dojos", dojoService.all());
		return "/ninja/index.jsp";
	}
	@PostMapping("/ninjas")
	public String update(@Valid @ModelAttribute("ninja")Ninja ninja,BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos",dojoService.all());
			return "/ninja/index.jsp";
		}
		else {
			ninjaService.create(ninja);
			return "redirect:/dojos/new";
		}
	}
}
