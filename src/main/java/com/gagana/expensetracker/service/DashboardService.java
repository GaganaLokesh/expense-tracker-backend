package com.gagana.expensetracker.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagana.expensetracker.dto.DashboardResponseDTO;
import com.gagana.expensetracker.entity.SavingsGoal;
import com.gagana.expensetracker.entity.User;
import com.gagana.expensetracker.exception.UserNotFoundException;
import com.gagana.expensetracker.repository.ExpenseRepository;
import com.gagana.expensetracker.repository.IncomeRepository;
import com.gagana.expensetracker.repository.InvestmentRepository;
import com.gagana.expensetracker.repository.SavingsGoalRepository;
import com.gagana.expensetracker.repository.UserRepository;

@Service
public class DashboardService {
	
	@Autowired
	IncomeRepository incomeRepository;
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	InvestmentRepository investmentRepository;
	
	@Autowired
	SavingsGoalRepository savingsGoalRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public DashboardResponseDTO getDashboardData(Long userId) {
		
		User user=userRepository.findById(userId)
				.orElseThrow(()->new UserNotFoundException("User noty found with id:"+userId));
		
		Double income=incomeRepository.getTotalIncomeByUserId(userId);
		Double expense=expenseRepository.getTotalExpenseByUserId(userId);
		Double savings=income-expense;
		Double monthlyGoal = 0.0;
		Boolean goalAchieved=false;
		
	    Optional<SavingsGoal> goalOpt=savingsGoalRepository.findByUserAndMonthAndYear(
	    				user,
	    				LocalDate.now().getMonthValue(),
	    				LocalDate.now().getYear()
	    				);
	    
	    if(goalOpt.isPresent()) {
//	    	SavingsGoal goal=goalOpt.get();
	    	monthlyGoal=goalOpt.get().getTargetAmount();
	    	 goalAchieved = savings >= monthlyGoal;
	    	
	    }
		Double investments=investmentRepository.getTotalInvestmentByUserId(userId);
		
		return new DashboardResponseDTO(income, expense, savings, monthlyGoal, goalAchieved, investments);
	}

}
