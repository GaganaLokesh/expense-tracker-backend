package com.gagana.expensetracker.dto;

import java.time.LocalDateTime;

import com.gagana.expensetracker.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SavingsGoalResponseDTO {

	private Long goalId;
	private int month;
	private int year;
	private Double targetAmount;
	private LocalDateTime createdAt;
	private Long userId;
}
