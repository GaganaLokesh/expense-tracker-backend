package com.gagana.expensetracker.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagana.expensetracker.dto.InvestmentRequestDTO;
import com.gagana.expensetracker.dto.InvestmentResponseDTO;
import com.gagana.expensetracker.entity.Investment;
import com.gagana.expensetracker.entity.User;
import com.gagana.expensetracker.exception.UserNotFoundException;
import com.gagana.expensetracker.repository.InvestmentRepository;
import com.gagana.expensetracker.repository.UserRepository;

@Service
public class InvestmentService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	InvestmentRepository investmentRepository;
	
	public InvestmentResponseDTO createInvestment(InvestmentRequestDTO dto) {
		User user=userRepository.findById(dto.getUserId())
				.orElseThrow(()->new UserNotFoundException("User not found with id: "+dto.getUserId()));
		Investment investment=new Investment();
		investment.setType(dto.getType());
		investment.setAmount(dto.getAmount());
		investment.setCreatedAt(LocalDateTime.now());
		investment.setUser(user);
		Investment savedInvestment=investmentRepository.save(investment);
		
		return new InvestmentResponseDTO(savedInvestment.getInvestmentId(), savedInvestment.getType(), 
				savedInvestment.getAmount(),savedInvestment.getCreatedAt(),savedInvestment.getUser().getUserId());
		
	}
	public Double getTotalInvestment(Long userId) {
		userRepository.findById(userId)
		.orElseThrow(()->new UserNotFoundException("User not found with id: "+userId));
		return  investmentRepository.getTotalInvestmentByUserId(userId);
		
	}

}
