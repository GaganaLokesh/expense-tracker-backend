package com.gagana.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SavingsResponseDTO {
	
	private Double totalIncome;
	private Double totalExpense;
	private Double savings;

}
