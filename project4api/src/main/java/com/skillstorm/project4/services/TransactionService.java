package com.skillstorm.project4.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project4.dtos.TransactionDto;
import com.skillstorm.project4.models.CustomUserDetails;
import com.skillstorm.project4.models.Goal;
import com.skillstorm.project4.models.Transaction;
import com.skillstorm.project4.respositories.GoalRepository;
import com.skillstorm.project4.respositories.TransactionRepository;

@Service
@Transactional
public class TransactionService {
    @Autowired
    public TransactionRepository transactionRepository;
    @Autowired
    public GoalRepository goalRepository;
    
    public List<Transaction> fetchTransactions(Goal goal){
    	return null;
    }
    
    public Transaction createTransaction(CustomUserDetails customUserDetails, TransactionDto transaction) {
    	Goal savedGoal = goalRepository.findById(transaction.getGoalId()).get();
    	Transaction newTransaction = new Transaction(transaction.getAmount(), customUserDetails.getAccount(),savedGoal);
    	BigDecimal newTotal = savedGoal.getCurrentAmount().add(transaction.getAmount());
		if (savedGoal != null) {
			savedGoal.setCurrentAmount(newTotal);
			goalRepository.save(savedGoal);
		}
		return transactionRepository.save(newTransaction);
    }
}
