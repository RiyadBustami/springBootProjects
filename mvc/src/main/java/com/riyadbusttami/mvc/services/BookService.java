package com.riyadbusttami.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.riyadbusttami.mvc.models.Book;
import com.riyadbusttami.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	public Book findBook(Long id){
		Optional<Book> optionalBook=bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
//	public Book updateBook(Long id,String title,String desc,String lang,Integer numOfPages) {
//		Optional<Book> optionalBook = bookRepository.findById(id);
//		if(optionalBook.isPresent()) {
//			Book book=optionalBook.get();
//			book.setDescription(desc);
//			book.setLanguage(lang);
//			book.setNumberOfPages(numOfPages);
//			book.setTitle(title);
//			return bookRepository.save(book);
//		}
//		else {
//			return null;
//		}
//	}
	public Book updateBook(Book book) {
		Optional<Book> optionalBook =bookRepository.findById(book.getId());
		if(optionalBook.isPresent()) {
			return bookRepository.save(book);
		}
		else {
			return null;
		}
		
		

	}
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
