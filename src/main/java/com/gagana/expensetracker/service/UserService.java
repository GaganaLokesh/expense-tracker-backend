package com.gagana.expensetracker.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagana.expensetracker.entity.User;
import com.gagana.expensetracker.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
	 
		if(userRepository.existsByUserEmail(user.getUserEmail())) {
			throw new RuntimeException("Email already Exists!!");
		}
		
		 user.setCreatedAt(LocalDateTime.now());
		 return userRepository.save(user);
	}

}
