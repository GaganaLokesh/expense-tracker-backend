package com.gagana.expensetracker.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagana.expensetracker.dto.SavingsGoalResponseDTO;
import com.gagana.expensetracker.entity.SavingsGoal;
import com.gagana.expensetracker.entity.User;
import com.gagana.expensetracker.exception.UserNotFoundException;
import com.gagana.expensetracker.repository.SavingsGoalRepository;
import com.gagana.expensetracker.repository.UserRepository;

@Service
public class SavingsGoalService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SavingsGoalRepository savingsGoalRepository;
	
	public SavingsGoalResponseDTO addOrUpdateGoal(Long userId, int month, int year, Double targetAmount) {
		User user=userRepository.findById(userId)
		.orElseThrow(()->new UserNotFoundException("User not found with id :"+ userId));
		
		SavingsGoal goal=savingsGoalRepository
				.findByUserAndMonthAndYear(user, month, year)
				.orElseGet(SavingsGoal::new);
		
		    goal.setMonth(month);
	        goal.setYear(year);
	        goal.setTargetAmount(targetAmount);
	        goal.setUser(user);
	        
	        if (goal.getCreatedAt() == null) {
	            goal.setCreatedAt(LocalDateTime.now());
	        }
	        SavingsGoal savedGoal = savingsGoalRepository.save(goal);

	        return new SavingsGoalResponseDTO(
	                savedGoal.getGoalId(),
	                savedGoal.getMonth(),
	                savedGoal.getYear(),
	                savedGoal.getTargetAmount(),
	                savedGoal.getCreatedAt(),
	                savedGoal.getUser().getUserId()
	        );

	}

}
