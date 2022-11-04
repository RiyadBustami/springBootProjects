package com.riyadbusttami.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riyadbusttami.mvc.models.Book;
import com.riyadbusttami.mvc.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	private final BookService bookService;
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id,Model model) {
		Book book=bookService.findBook(id);
		model.addAttribute("book",book);
		return "show.jsp";
	}

}
