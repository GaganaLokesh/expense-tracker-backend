package com.gagana.expensetracker.controller;
import com.gagana.expensetracker.service.ExpenseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gagana.expensetracker.dto.ExpenseRequestDTO;
import com.gagana.expensetracker.dto.ExpenseResponseDTO;


@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

	@Autowired
    private ExpenseService expenseService;

   
	@PostMapping
	public ExpenseResponseDTO addExpense(@RequestBody ExpenseRequestDTO expenseRequestDTO) {
		return expenseService.addExpense(expenseRequestDTO);
		}
	
	@GetMapping("/user/{userId}")
	public List<ExpenseResponseDTO> getExpensesByUser(@PathVariable Long userId) {
	    return expenseService.getExpensesByUser(userId);
	}


}


