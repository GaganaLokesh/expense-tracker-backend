package com.gagana.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gagana.expensetracker.dto.DashboardResponseDTO;
import com.gagana.expensetracker.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
	
	@Autowired
	DashboardService dashboardService;
	
	@GetMapping("/user/{userId}")
	public DashboardResponseDTO getDashBoardData(@PathVariable Long userId) {
		return dashboardService.getDashboardData(userId);
		
	}

}
