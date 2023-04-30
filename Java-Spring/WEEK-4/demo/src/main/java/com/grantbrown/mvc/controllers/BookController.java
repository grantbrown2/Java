package com.grantbrown.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grantbrown.mvc.models.Book;
import com.grantbrown.mvc.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {
	private final BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/books";
	}

	@RequestMapping("/books/{bookId}")
	public String locateBook(@PathVariable("bookId") Long bookId, Model viewmodel) {
		Book book = bookService.findBook(bookId);
		viewmodel.addAttribute("showBook", book);
		return "show.jsp";
	}
	
	@RequestMapping("/books")
	public String allBooks(Model viewmodel) {
		List<Book> books = bookService.allBooks();
		viewmodel.addAttribute("books", books);
		return "index.jsp";
	}
	
	
	
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	@PostMapping("/books")
	public String create(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		bookService.createBook(book);
		return "redirect:/books";
	}
	
	
	
	
	@RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    
    @GetMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("book", book);
            return "edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
}
