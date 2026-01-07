package com.gagana.expensetracker.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="expenses")
public class Expense {
	
	@Id
	@Column(name="expense_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long expenseID;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private Double amount;
	
	@Column(nullable=false)
	private String category;
	
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	

}
