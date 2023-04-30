package com.grantbrown.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grantbrown.savetravels.models.Expense;

@Repository
public interface ExpensesRepository extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
}
