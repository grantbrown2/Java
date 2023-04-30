package com.grantbrown.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grantbrown.savetravels.models.Expense;
import com.grantbrown.savetravels.repositories.ExpensesRepository;

@Service
public class ExpensesService {
	private final ExpensesRepository expensesRepository;
	public ExpensesService(ExpensesRepository expensesRepository) {
		this.expensesRepository = expensesRepository;
	}
	
	public List<Expense> allExpenses() {
		return expensesRepository.findAll();
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expensesRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	public Expense createExpense(Expense expenses) {
		return expensesRepository.save(expenses);
	}
	
	public Expense updateExpense(Expense expense) {
		Optional<Expense> optionalExpense = expensesRepository.findById(expense.getId());
		if(optionalExpense.isPresent()) {
			Expense existingExpense = optionalExpense.get();
			existingExpense.setExpenseName(expense.getExpenseName());
			existingExpense.setVendor(expense.getVendor());
			existingExpense.setAmount(expense.getAmount());
			existingExpense.setDescription(expense.getDescription());
			return expensesRepository.save(existingExpense);
		} else {
			return null;
		}
	}
	
	public void deleteExpense(Long id) {
		expensesRepository.deleteById(id);
	}
}
