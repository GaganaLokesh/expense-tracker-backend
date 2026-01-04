package com.gagana.expensetracker.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagana.expensetracker.entity.User;
import com.gagana.expensetracker.exception.EmailAlreadyExistsExcepetion;
import com.gagana.expensetracker.exception.UserNotFoundException;
import com.gagana.expensetracker.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
	 
		if(userRepository.existsByUserEmail(user.getUserEmail())) {
			throw new EmailAlreadyExistsExcepetion("Email already Exists!!");
		}
		 user.setCreatedAt(LocalDateTime.now());
		 return userRepository.save(user);
	}
	public User getUserById(Long userId) {
//		Optional<User> userOpt=userRepository.findById(userId);
//		if(userOpt.isPresent()) {
//			return userOpt.get();
//		}
//		else {
//			throw new UserNotFoundException("User Not found eith id: "+userId);
//		}
		return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found exception with id:"+userId));
		
	}

}
