package com.riyadbusttami.omikujiforms.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {

	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/show")
	public String show(
			@RequestParam("number") Integer number,
			@RequestParam("city") String city,
			@RequestParam("name") String name,
			@RequestParam("profession") String profession,
			@RequestParam("living_thing") String livingThing,
			@RequestParam("comment") String comment
			,Model model) {
		
		model.addAttribute("number",number);
		model.addAttribute("city",city);
		model.addAttribute("name",name);
		model.addAttribute("profession",profession);
		model.addAttribute("living_thing",livingThing);
		model.addAttribute("comment",comment);
		
		return "show.jsp";
		
	}
}
