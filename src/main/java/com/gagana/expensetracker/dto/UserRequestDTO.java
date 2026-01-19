package com.gagana.expensetracker.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRequestDTO {
	
	@NotBlank(message="User name can not be blank")
	private String userName;
	
	@NotBlank(message="Email cannot be blank")
	@Email(message = "Invalid email format")
	private String userEmail;
	
	@NotBlank (message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters")
	private String userPassword;

}
