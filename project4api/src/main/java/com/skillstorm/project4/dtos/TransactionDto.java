package com.skillstorm.project4.dtos;

import java.math.BigDecimal;

public class TransactionDto {

	private BigDecimal amount;
	private int goalId;
	public TransactionDto() {
		super();
	}
	
	public TransactionDto(BigDecimal amount) {
		super();
		this.amount = amount;
	}

	public TransactionDto(BigDecimal amount, int goalId) {
		super();
		this.amount = amount;
		this.goalId = goalId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	@Override
	public String toString() {
		return "TransactionDto [amount=" + amount + ", goalId=" + goalId + "]";
	}
	
	
}
