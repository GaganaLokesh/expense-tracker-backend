package com.gagana.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gagana.expensetracker.entity.Expense;
import com.gagana.expensetracker.entity.User;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
	List<Expense> findByUser(User user);
	
	@Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.user.userId = :userId")
	Double getTotalExpenseByUserId(Long userId);
	
	@Query("""
		    SELECT COALESCE(SUM(e.amount), 0)
		    FROM Expense e
		    WHERE e.user.userId = :userId
		      AND YEAR(e.createdAt) = :year
		      AND MONTH(e.createdAt) = :month
		""")
		Double getMonthlyExpense(Long userId, int year, int month);

}
