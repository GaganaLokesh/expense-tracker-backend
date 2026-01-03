package com.gagana.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gagana.expensetracker.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean  existsByUserEmail(String userEmail);
}
