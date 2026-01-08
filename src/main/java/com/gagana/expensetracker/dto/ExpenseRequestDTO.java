package com.gagana.expensetracker.dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExpenseRequestDTO {
	private String title;
    private Double amount;
    private String category;
    private Long userId;


}
