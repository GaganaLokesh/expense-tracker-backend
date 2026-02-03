package com.gagana.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagana.expensetracker.dto.SavingsResponseDTO;
import com.gagana.expensetracker.exception.UserNotFoundException;
import com.gagana.expensetracker.repository.ExpenseRepository;
import com.gagana.expensetracker.repository.IncomeRepository;
import com.gagana.expensetracker.repository.UserRepository;

@Service
public class SavingsService {
	
	@Autowired
	IncomeRepository incomeRepository;
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public SavingsResponseDTO savingsByUser(Long userId) {
		
		 userRepository.findById(userId)
	        .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
	Double totalIncome=incomeRepository.getTotalIncomeByUserId(userId);
	Double totalExpense=expenseRepository.getTotalExpenseByUserId(userId);
	Double savings=totalIncome-totalExpense;
	return  new SavingsResponseDTO(totalIncome, totalExpense,savings); 
	
	}
}
