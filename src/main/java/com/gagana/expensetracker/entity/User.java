package com.gagana.expensetracker.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_details")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(name = "user_email", nullable = false, unique = true)
	private String userEmail;
	
	@Column(name = "user_password", nullable = false)
	private String userPassword;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	

}
