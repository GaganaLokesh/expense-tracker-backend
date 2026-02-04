package com.gagana.expensetracker.dto;

import com.gagana.expensetracker.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class SavingsGoalRequestDTO {
	
	private int month;
	private int year;
	private Double targetAmount;
	private Long userId;

}
