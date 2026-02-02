package com.gagana.expensetracker.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IncomeRequestDTO {

	private String source;
	private Double amount;
	private Long userId;
}
