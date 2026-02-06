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
@Table(name="investment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Investment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="investment_id")
	private Long investmentId;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private Double amount;
	
	@Column(name="created_at", nullable = false)
	private LocalDateTime  createdAt;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;

}
