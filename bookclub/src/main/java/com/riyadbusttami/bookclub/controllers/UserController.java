package com.riyadbusttami.bookclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.riyadbusttami.bookclub.models.LoginUser;
import com.riyadbusttami.bookclub.models.User;
import com.riyadbusttami.bookclub.services.UserService;

@Controller
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser")User newUser,@ModelAttribute("newLogin")LoginUser newLogin, HttpSession session ) {
		if(session.getAttribute("loggedUser")!=null) {
			return "redirect:/home";
		}
		else {
		return "index.jsp";
		}
	}
	@PostMapping("/register")
	public String register(@ModelAttribute("newUser")User newUser,BindingResult result, Model model, HttpSession session) {
		User user=userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		else {
			session.setAttribute("loggedUser", user);
			return "redirect:/home";
		}
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("newLogin")LoginUser newLogin,BindingResult result, Model model, HttpSession session) {
		User user=userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		else {
			session.setAttribute("loggedUser", user);
			return "redirect:/home";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("loggedUser")!=null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	@GetMapping("/home")
	public String success(HttpSession session) {
		if(session.getAttribute("loggedUser")!=null) {
			return "redirect:/books";
		}
		else {
			return "redirect:/";
		}
	}
}
