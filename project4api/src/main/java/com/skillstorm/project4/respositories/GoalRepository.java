package com.skillstorm.project4.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.project4.models.Account;
import com.skillstorm.project4.models.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {
	
	//@Query("SELECT g FROM Goal g WHERE g.account.id = ?1")
	List<Goal> findByAccountId(int id);
}
