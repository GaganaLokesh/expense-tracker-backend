package com.gagana.expensetracker.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeResponseDTO {

	private Long incomeId;
	private String source;
	private Double amount;
	private LocalDateTime createdAt;
	private Long userId;
}
