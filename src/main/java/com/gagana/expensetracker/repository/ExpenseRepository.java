package com.gagana.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gagana.expensetracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
