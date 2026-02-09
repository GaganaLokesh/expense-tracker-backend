package com.gagana.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gagana.expensetracker.dto.LoginRequestDTO;
import com.gagana.expensetracker.dto.LoginResponseDTO;
import com.gagana.expensetracker.entity.User;
import com.gagana.expensetracker.exception.UserNotFoundException;
import com.gagana.expensetracker.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public LoginResponseDTO login(LoginRequestDTO request) {
		User user=userRepository.findByUserEmail(request.getEmail())
				.orElseThrow(()->new UserNotFoundException("Invalid email or password"));
	
	
	boolean passwordMatches=passwordEncoder.matches(request.getPassword(), user.getUserPassword());
	 if (!passwordMatches) {
         throw new UserNotFoundException("Invalid email or password");
     }

     return new LoginResponseDTO("Login successful");
	}
}
