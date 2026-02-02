package com.gagana.expensetracker.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagana.expensetracker.dto.IncomeRequestDTO;
import com.gagana.expensetracker.dto.IncomeResponseDTO;
import com.gagana.expensetracker.dto.TotalIncomeResponseDTO;
import com.gagana.expensetracker.entity.Income;
import com.gagana.expensetracker.entity.User;
import com.gagana.expensetracker.exception.UserNotFoundException;
import com.gagana.expensetracker.repository.IncomeRepository;
import com.gagana.expensetracker.repository.UserRepository;

@Service
public class IncomeService {
	
	@Autowired
	UserRepository  userRepository;
	
	@Autowired
	IncomeRepository incomeRepository;
	
	public IncomeResponseDTO addIncome(IncomeRequestDTO incomeRequestDTO) {
		//Finding the user
		User user=userRepository.findById(incomeRequestDTO.getUserId())
				.orElseThrow(()->new UserNotFoundException("User not found with id:"+incomeRequestDTO.getUserId()));
		//creating income
		Income income=new Income();
		income.setSource(incomeRequestDTO.getSource());
		income.setAmount(incomeRequestDTO.getAmount());
		income.setCreatedAt(LocalDateTime.now());
		
		//linking user to income
		income.setUser(user);
		//save income to db
		Income savedIncome=incomeRepository.save(income);
		
		//return using dto
		return mapToIncomeResponseDTO(savedIncome);
	}
	
	public List<IncomeResponseDTO> getIncomesByUser(Long userId) {

	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

	    return incomeRepository.findByUser(user)
	            .stream()
	            .map(this::mapToIncomeResponseDTO)
	            .toList();
	}
	
	public TotalIncomeResponseDTO getTotalIncome(Long userId) {
		userRepository.findById(userId)
				.orElseThrow(()->new UserNotFoundException("User not found with id:"+ userId));
		Double totalIncome=incomeRepository.getTotalIncomeByUserId(userId);
		
		return new TotalIncomeResponseDTO(totalIncome);
	}
	
	//dto converter
	private IncomeResponseDTO mapToIncomeResponseDTO(Income income) {
		return new IncomeResponseDTO(
				income.getIncomeId(),
				income.getSource(),
				income.getAmount(),
				income.getCreatedAt(),
				income.getUser().getUserId()
				);
	}

}
