package com.gagana.expensetracker.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserResponseDTO {

	private Long userId;
	private String userName;
	private String userEmail;
	private LocalDateTime createdAt;
	
}
