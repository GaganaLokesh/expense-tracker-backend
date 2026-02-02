package com.gagana.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gagana.expensetracker.entity.Income;
import com.gagana.expensetracker.entity.User;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long>{
	
	List<Income> findByUser(User user);
	
	@Query("SELECT COALESCE(SUM(i.amount),0) FROM Income i WHERE i.user.userId=:userId")
	Double getTotalIncomeByUserId(Long userId);

}
