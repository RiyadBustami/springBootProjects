package com.riyadbusttami.bookclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riyadbusttami.bookclub.models.Book;
import com.riyadbusttami.bookclub.models.User;
import com.riyadbusttami.bookclub.services.BookService;
import com.riyadbusttami.bookclub.services.UserService;

@Controller
@RequestMapping("/bookmarket")
public class BookBrokerController {
	private final BookService bookService;
	private final UserService userService;
	
	
	public BookBrokerController(BookService bookService, UserService userService) {
		this.bookService = bookService;
		this.userService = userService;
	}
	
	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("loggedUser")==null)return "redirect:/";
		User curUser= userService.get((User)session.getAttribute("loggedUser"));
		model.addAttribute("thisUser", curUser);
		model.addAttribute("notBorrowedBooks",bookService.getAllNotBorrowed());
		return "/bookbroker/index.jsp";
	}
	
	@GetMapping("/{id}/borrow")
	public String borrow(@PathVariable("id")Long id,HttpSession session, Model model) {
		if(session.getAttribute("loggedUser")==null)return "redirect:/";
		Book book=bookService.find(id);
		User curUser= userService.get((User)session.getAttribute("loggedUser"));
		if(book.getBorrower()==null) {
			book.setBorrower(curUser);
			bookService.update(book);
		}
		return "redirect:/bookmarket";
	}
	@GetMapping("/{id}/return")
	public String returnBook(@PathVariable("id")Long id, HttpSession session, Model model) {
		if(session.getAttribute("loggedUser")==null)return "redirect:/";
		Book book=bookService.find(id);
		User curUser= userService.get((User)session.getAttribute("loggedUser"));
		if(book.getBorrower().getId()==curUser.getId()) {
			book.setBorrower(null);
			bookService.update(book);
		}
		return "redirect:/bookmarket";
	}

}
