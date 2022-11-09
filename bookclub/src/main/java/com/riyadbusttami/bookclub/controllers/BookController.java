package com.riyadbusttami.bookclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riyadbusttami.bookclub.models.Book;
import com.riyadbusttami.bookclub.models.User;
import com.riyadbusttami.bookclub.services.BookService;
import com.riyadbusttami.bookclub.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
	private UserService userService;
	private BookService bookService;
	public BookController(UserService userService, BookService bookService) {
		this.userService = userService;
		this.bookService = bookService;
	}
	
	@GetMapping("")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("loggedUser")==null)return "redirect:/";
		else {
			model.addAttribute("allBooks", bookService.all());
			model.addAttribute("loggeUser", userService.get((User)session.getAttribute("loggedUser")));
			return "/books/index.jsp";
		}
	}
	
	@GetMapping("/new")
	public String newBook(@ModelAttribute("book")Book book,BindingResult result, HttpSession session) {
		if(session.getAttribute("loggedUser")==null)return "redirect:/";
		else {
			return "/books/new.jsp";
		}
	}
	
	@PostMapping("")
	public String create(@ModelAttribute("book")Book book,BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "/books/new.jsp"; 
		}
		else {
			book.setUser((User)session.getAttribute("loggedUser"));
			bookService.create(book);
			return "redirect:/books";
		}
	}
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.find(id));
		return "/books/show.jsp";
	}
	
}
