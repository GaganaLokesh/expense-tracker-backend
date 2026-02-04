package com.gagana.expensetracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gagana.expensetracker.entity.SavingsGoal;
import com.gagana.expensetracker.entity.User;

@Repository
public interface SavingsGoalRepository extends JpaRepository<SavingsGoal, Long> {
	
	Optional<SavingsGoal> findByUserAndMonthAndYear(User user, int month, int year);
   
}
