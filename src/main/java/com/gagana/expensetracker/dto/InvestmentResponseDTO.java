package com.gagana.expensetracker.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentResponseDTO {

	private Long investmentId;
	private String type;
	private Double amount;
	private LocalDateTime createdAt;
	private Long userId;
}
