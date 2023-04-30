package com.grantbrown.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grantbrown.mvc.models.Book;
import com.grantbrown.mvc.repositories.BookRepository;
@Service
public class BookService {
 // adding the book repository as a dependency
 private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 // updates a book
 public Book updateBook(Book book) {
	 Optional<Book> optionalBook = bookRepository.findById(book.getId());
	 if(optionalBook.isPresent()) {
		 Book existingBook = optionalBook.get();
		 existingBook.setTitle(book.getTitle());
		 existingBook.setDescription(book.getDescription());
		 existingBook.setLanguage(book.getLanguage());
		 existingBook.setNumberOfPages(book.getNumberOfPages());
		 return bookRepository.save(existingBook);
	 } else {
		 return null;
	 }
 }
 // deletes a book
 public void deleteBook(Long id) {
	 bookRepository.deleteById(id);
 }
}

