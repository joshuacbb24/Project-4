package com.skillstorm.project4.services;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project4.dtos.GoalDto;
import com.skillstorm.project4.models.Account;
import com.skillstorm.project4.models.CustomUserDetails;
import com.skillstorm.project4.models.Goal;
import com.skillstorm.project4.respositories.GoalRepository;

@Service
@Transactional
public class GoalService {
    @Autowired
    public GoalRepository goalRepository;
    
    public List<Goal> fetchGoals(CustomUserDetails customUserDetails){
    	return goalRepository.findByAccountId(customUserDetails.getId());
    }
    
    public Goal fetchGoal(int id) {
    	Goal goal = goalRepository.findById(id).get();
    	return goal;
    }
    
    public Goal createGoal(CustomUserDetails customUserDetails, GoalDto goal) {
    	Set<Account> accounts = new HashSet<Account>();
    	accounts.add(customUserDetails.getAccount());
    	Goal newGoal = new Goal(goal.getName(), goal.getEndDate(), goal.getDescription(), accounts, goal.getTargetGoal(), goal.getCurrentAmount());
    	return goalRepository.save(newGoal);
    }
    
    public Goal updateGoal(int id, GoalDto newGoal, CustomUserDetails customUserDetails) {
    		Goal savedGoal = goalRepository.findById(id).get();
    		if (savedGoal != null) {
    			savedGoal.setDescription(newGoal.getDescription());
    			savedGoal.setEndDate(newGoal.getEndDate());
    			savedGoal.setName(newGoal.getName());
    			savedGoal.setCurrentAmount(newGoal.getCurrentAmount());
    			savedGoal.setTargetGoal(newGoal.getTargetGoal());
    		}
    		return goalRepository.save(savedGoal);	
    }
    
    public void deleteGoal(int id) {
    	goalRepository.deleteById(id);
    }
    
    public void deleteGoals(List<Goal> goals, CustomUserDetails customUserDetails) {
    	
    }
}
