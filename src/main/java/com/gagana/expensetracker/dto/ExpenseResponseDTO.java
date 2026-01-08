package com.gagana.expensetracker.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponseDTO {
	  private Long expenseId;
	    private String title;
	    private Double amount;
	    private String category;
	    private LocalDateTime createdAt;
	    private Long userId;

}
