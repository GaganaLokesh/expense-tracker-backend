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

@Entity
@Table(name="savings_goal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SavingsGoal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="goal_id")
	private Long goalId;
	
	@Column(name="month", nullable = false)
	private int month;
	
	@Column(name="year", nullable = false)
	private int year;
	
	@Column(name="target_amount", nullable = false)
	private Double targetAmount;
	
	@Column(name="created_at", nullable = false)
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

}
