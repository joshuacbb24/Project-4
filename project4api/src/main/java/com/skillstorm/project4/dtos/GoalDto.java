package com.skillstorm.project4.dtos;

import java.math.BigDecimal;

public class GoalDto {
	private String name;
	private String description;
	private String endDate;
	private BigDecimal targetGoal;
	public GoalDto() {
		super();
	}
	public GoalDto(String name, String description, String endDate, BigDecimal targetGoal) {
		super();
		this.name = name;
		this.description = description;
		this.endDate = endDate;
		this.targetGoal = targetGoal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getTargetGoal() {
		return targetGoal;
	}
	public void setTargetGoal(BigDecimal targetGoal) {
		this.targetGoal = targetGoal;
	}
	@Override
	public String toString() {
		return "GoalDto [name=" + name + ", description=" + description + ", endDate=" + endDate + ", targetGoal="
				+ targetGoal + "]";
	}
	
	
}
