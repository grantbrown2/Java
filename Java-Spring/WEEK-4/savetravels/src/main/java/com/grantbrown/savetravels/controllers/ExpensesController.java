package com.grantbrown.savetravels.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grantbrown.savetravels.models.Expense;
import com.grantbrown.savetravels.services.ExpensesService;

import jakarta.validation.Valid;

@Controller
public class ExpensesController {
	private final ExpensesService expensesService;
	public ExpensesController(ExpensesService expensesService) {
		this.expensesService = expensesService;
	}

	@RequestMapping("/")
	public String redirect() {
		return "redirect:/expenses";
	}
	@RequestMapping("/expenses")
	public String allExpenses(Model viewmodel, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expensesService.allExpenses();
		viewmodel.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@GetMapping("/expenses/view/{id}")
	public String showExpense(@PathVariable("id") Long id, Model viewmodel) {
		Expense expense = expensesService.findExpense(id);
		viewmodel.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	@PostMapping("/expenses/new")
	public String newExpense(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model viewmodel) {
		if (result.hasErrors()) {
			List<Expense> expenses = expensesService.allExpenses();
			viewmodel.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		expensesService.createExpense(expense);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String editExpense(Model viewmodel, @PathVariable("id") Long id) {
		viewmodel.addAttribute("expense", this.expensesService.findExpense(id));
		return "edit.jsp";
	}
	
	@PutMapping(value="/expenses/update/{id}")
	public String updateExpense(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model viewmodel) {
		if (result.hasErrors()) {
			viewmodel.addAttribute("expense", expense);
			return "edit.jsp";
		} else {
			this.expensesService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping(value="/expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expensesService.deleteExpense(id);
		return "redirect:/";
	}
}
