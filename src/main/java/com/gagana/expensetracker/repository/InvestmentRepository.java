package com.gagana.expensetracker.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gagana.expensetracker.entity.Investment;
import com.gagana.expensetracker.entity.User;

public interface InvestmentRepository extends JpaRepository<Investment, Long>{
	
	List<Investment> findByUser(User user);
	
	@Query(" SELECT COALESCE(SUM(i.amount), 0) FROM Investment i WHERE i.user.userId=:userId ")
	Double getTotalInvestmentByUserId(Long userId);

}
