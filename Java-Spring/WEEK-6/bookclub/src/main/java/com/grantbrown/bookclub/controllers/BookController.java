package com.grantbrown.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
}
