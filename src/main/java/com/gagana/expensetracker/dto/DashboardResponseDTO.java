package com.gagana.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponseDTO {
	
	private Double totalIncome;
	private Double totalExpense;
	private Double savings;
	private Double monthlyGoal;
	private Boolean goalAchieved;
	private Double totalInvestment;

}
