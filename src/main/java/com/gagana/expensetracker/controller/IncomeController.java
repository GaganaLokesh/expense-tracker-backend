package com.gagana.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gagana.expensetracker.dto.IncomeRequestDTO;
import com.gagana.expensetracker.dto.IncomeResponseDTO;
import com.gagana.expensetracker.dto.TotalIncomeResponseDTO;
import com.gagana.expensetracker.service.IncomeService;

@RestController
@RequestMapping("/api/incomes")

public class IncomeController {
	@Autowired
	private IncomeService incomeService;
	
	@PostMapping
	public IncomeResponseDTO addIncome(@RequestBody IncomeRequestDTO incomeRequestDTO) {
		return incomeService.addIncome(incomeRequestDTO);
	}
	
	@GetMapping("/user/{userId}")
	public List<IncomeResponseDTO> getIncomesByUser(@PathVariable Long userId){
		return incomeService.getIncomesByUser(userId);
	}
	
	@GetMapping("/user/{userId}/total")
	public TotalIncomeResponseDTO getTotalIncome(@PathVariable Long userId) {
		return incomeService.getTotalIncome(userId);
	}

}
