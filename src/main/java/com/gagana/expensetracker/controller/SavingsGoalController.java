package com.gagana.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gagana.expensetracker.dto.SavingsGoalRequestDTO;
import com.gagana.expensetracker.dto.SavingsGoalResponseDTO;
import com.gagana.expensetracker.service.SavingsGoalService;

@RestController
@RequestMapping("/api/savings-goals")
public class SavingsGoalController {
   
	@Autowired
	SavingsGoalService savingsGoalService;
	
	@PostMapping
	public SavingsGoalResponseDTO addOrUpdate(@RequestBody SavingsGoalRequestDTO requestDTO) {
		return savingsGoalService.addOrUpdateGoal( requestDTO.getUserId(),
                requestDTO.getMonth(),
                requestDTO.getYear(),
                requestDTO.getTargetAmount());
	}
}
