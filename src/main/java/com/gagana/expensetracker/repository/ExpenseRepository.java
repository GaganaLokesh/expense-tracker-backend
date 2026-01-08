package com.gagana.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gagana.expensetracker.entity.Expense;
import com.gagana.expensetracker.entity.User;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
	List<Expense> findByUser(User user);
}
