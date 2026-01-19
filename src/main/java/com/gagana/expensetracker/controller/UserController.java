package com.gagana.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gagana.expensetracker.dto.UserRequestDTO;
import com.gagana.expensetracker.dto.UserResponseDTO;
import com.gagana.expensetracker.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
		return userService.createUser(userRequestDTO);
	}
	
	@GetMapping("/{id}")
	public UserResponseDTO getUser(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	

}
