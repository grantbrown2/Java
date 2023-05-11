package com.grantbrown.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.grantbrown.bookclub.models.Book;
import com.grantbrown.bookclub.services.BookService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	BookService bookServ;
	
	@GetMapping("/books")
	public String showBooks(
		    @ModelAttribute("book") Book book,
			Model viewmodel,
			HttpSession session) {
		String nameInSession = (String) session.getAttribute("userName");
		if (nameInSession == null) {
			return "redirect:/";
		}
		viewmodel.addAttribute("nameInSession", nameInSession);
		List<Book> books = bookServ.allBooks();
		viewmodel.addAttribute("books", books);
		return "books.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id,
			Model viewmodel,
			HttpSession session) {
		if (session.getAttribute("userName") == null) {
			return "redirect:/";
		}
		Book oneBook = bookServ.findBook(id);
		viewmodel.addAttribute("book", oneBook);
		return "show-book.jsp";
	}
	
	@GetMapping("/books/new")
	public String createBookForm(Model viewmodel, @ModelAttribute("book") Book book, HttpSession session) {
		if (session.getAttribute("userName") == null) {
			return "redirect:/";
		}
		viewmodel.addAttribute("book", book);
		return "new-book.jsp";
	}
	
	@PostMapping("/books/create")
	public String createBook(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			Model viewmodel,
			HttpSession session) {
		if (result.hasErrors()) {
			List<Book> books = bookServ.allBooks();
			viewmodel.addAttribute("books", books);
			return "new-book.jsp";
		}
		String createdBy = (String) session.getAttribute("userName");
		book.setCreatedBy(createdBy);
		bookServ.createBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/edit/{id}")
	public String editBookForm(Model viewmodel, @PathVariable("id") Long id, HttpSession session) {
		Book existingBook = bookServ.findBook(id);
		if (session.getAttribute("userName").equals(existingBook.getCreatedBy()) ) {
			viewmodel.addAttribute("book", existingBook);
			return "edit-book.jsp";
		}
		return "redirect:/books";
	}
	
	@PutMapping(value="/books/update/{id}")
	public String updateBook(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			Model viewmodel) {
		if (result.hasErrors()) {
			viewmodel.addAttribute("book", book);
			return "edit-book.jsp";
		} else {
			this.bookServ.editBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping(value="/books/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookServ.removeBook(id);
		return "redirect:/books";
	}
}
