package com.riyadbusttami.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.riyadbusttami.bookclub.models.Book;
import com.riyadbusttami.bookclub.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> all(){
		return bookRepository.findAll();
	}
	
	public Book create(Book book) {
		return bookRepository.save(book);
	}
	
	public Book find(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
	}
	
	public Book update(Book book) {
		if(bookRepository.findById(book.getId()).isPresent()) {
			return bookRepository.save(book);
		}
		else {
			return null;
		}
	}
	

}
