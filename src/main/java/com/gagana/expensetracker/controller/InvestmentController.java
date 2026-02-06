package com.gagana.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gagana.expensetracker.dto.InvestmentRequestDTO;
import com.gagana.expensetracker.dto.InvestmentResponseDTO;
import com.gagana.expensetracker.service.InvestmentService;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {
	
	@Autowired
	InvestmentService investmentService;
	
	@PostMapping
	public InvestmentResponseDTO addInvestment(@RequestBody InvestmentRequestDTO investmentRequestDTO) {
		return investmentService.createInvestment(investmentRequestDTO);
	}
	
	@GetMapping("/user/{userId}/total")
	public Double getTotalInvestmentByUser(@PathVariable Long userId) {
		return investmentService.getTotalInvestment(userId);
	}

}
