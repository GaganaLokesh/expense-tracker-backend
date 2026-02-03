package com.gagana.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gagana.expensetracker.dto.SavingsResponseDTO;
import com.gagana.expensetracker.service.SavingsService;

@RestController
@RequestMapping("/api/savings")
public class SavingsController {
	
	@Autowired
	SavingsService savingsService;
	
	@GetMapping("/user/{userId}")
	public SavingsResponseDTO getSavings(@PathVariable Long userId) {
		return savingsService.savingsByUser(userId);
	}

}
