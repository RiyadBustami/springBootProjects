package com.riyadbusttami.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riyadbusttami.mvc.models.Book;
import com.riyadbusttami.mvc.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	@RequestMapping("/books")
	public String index(Model model) {
		model.addAttribute("books",bookService.allBooks());
		return "/books/index.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook() {
		return "new.jsp";
	}
	
	@PostMapping("/books")
	public String create(@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("pages") Integer pages) {
		Book book = new Book(title,description,language,pages);
		book=bookService.createBook(book);
		return "redirect:/books/"+book.getId();
	}
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id,Model model) {
		Book book=bookService.findBook(id);
		model.addAttribute("book",book);
		return "show.jsp";
	}

}
