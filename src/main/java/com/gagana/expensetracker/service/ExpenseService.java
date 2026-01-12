package com.gagana.expensetracker.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagana.expensetracker.dto.ExpenseRequestDTO;
import com.gagana.expensetracker.dto.ExpenseResponseDTO;
import com.gagana.expensetracker.dto.ExpenseTotalResponseDTO;
import com.gagana.expensetracker.entity.Expense;
import com.gagana.expensetracker.entity.User;
import com.gagana.expensetracker.exception.UserNotFoundException;
import com.gagana.expensetracker.repository.ExpenseRepository;
import com.gagana.expensetracker.repository.UserRepository;

@Service
public class ExpenseService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	public ExpenseResponseDTO addExpense(ExpenseRequestDTO expenseRequestDTO) {
		
		//Finding the User
		User user=userRepository.findById(expenseRequestDTO.getUserId())
				.orElseThrow(()->new UserNotFoundException("User not found with id: "+expenseRequestDTO.getUserId()));
	
     //Creating expense
	 Expense expense=new Expense();
	 expense.setTitle(expenseRequestDTO.getTitle());
     expense.setAmount(expenseRequestDTO.getAmount());
     expense.setCategory(expenseRequestDTO.getCategory());
     expense.setCreatedAt(LocalDateTime.now());
     
     //Set user(Link user)
     expense.setUser(user);
     
     //Saving the expense
//     return expenseRepository.save(expense);
     Expense savedExpense=expenseRepository.save(expense);
     
     return mapToExpenseResponseDTO(savedExpense);
     
	}
	public List<ExpenseResponseDTO> getExpensesByUser(Long userId){
		User user=userRepository.findById(userId).
				orElseThrow(()-> new UserNotFoundException("User not found with id :"+ userId));
		List<Expense> expenses=expenseRepository.findByUser(user);
		return expenses.stream()
	            .map(this::mapToExpenseResponseDTO)
	            .toList();
	}
	public ExpenseTotalResponseDTO getTotalExpense(Long userId) {

	    userRepository.findById(userId)
	            .orElseThrow(() ->
	                    new UserNotFoundException("User not found with id: " + userId)
	            );

	    Double total = expenseRepository.getTotalExpenseByUserId(userId);

	    return new ExpenseTotalResponseDTO(total);
	}
	
	public ExpenseTotalResponseDTO getMonthlyExpense(Long userId, int year, int month) {

	    userRepository.findById(userId)
	            .orElseThrow(() ->
	                    new UserNotFoundException("User not found with id: " + userId)
	            );

	    Double total = expenseRepository.getMonthlyExpense(userId, year, month);

	    return new ExpenseTotalResponseDTO(total);
	}
	private ExpenseResponseDTO mapToExpenseResponseDTO(Expense expense) {
		  return new ExpenseResponseDTO(
		            expense.getExpenseID(),
		            expense.getTitle(),
		            expense.getAmount(),
		            expense.getCategory(),
		            expense.getCreatedAt(),
		            expense.getUser().getUserId()
		    );
	}
	
	
}
