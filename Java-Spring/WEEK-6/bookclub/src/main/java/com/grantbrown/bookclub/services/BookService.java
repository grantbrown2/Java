package com.grantbrown.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grantbrown.bookclub.models.Book;
import com.grantbrown.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public Book findBook(Long id) {
		Optional<Book> existingBook = bookRepo.findById(id);
		if (existingBook.isPresent()) {
			return existingBook.get();
		} else {
			return null;
		}
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public void removeBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	public Book editBook(Book book) {
		Optional<Book> optionalBook = bookRepo.findById(book.getId());
		if (optionalBook.isPresent()) {
			Book existingBook = optionalBook.get();
			existingBook.setTitle(book.getTitle());
			existingBook.setAuthor(book.getAuthor());
			existingBook.setMyThoughts(book.getMyThoughts());
			return bookRepo.save(existingBook);
		} else {
			return null;
		}
	}
}
