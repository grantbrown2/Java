package com.grantbrown.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grantbrown.bookclub.models.Book;
import com.grantbrown.bookclub.models.User;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findByBorrower(User borrower);
	List<Book> findAllByBorrowerIsNull();
}
