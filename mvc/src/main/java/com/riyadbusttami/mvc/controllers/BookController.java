package com.riyadbusttami.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		else {
			book=bookService.createBook(book);
			return "redirect:/books/"+book.getId();
		}
	}
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id,Model model) {
		Book book=bookService.findBook(id);
		model.addAttribute("book",book);
		return "show.jsp";
	}
	@GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    
    @PutMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }

}
