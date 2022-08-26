package com.skillstorm.project4.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="GOAL")
public class Goal {

	private UUID id;
	private String name;
	private String startDate;
	private String endDate;
	private Account account;
	private long goalTarget;
	private long currentAmount;
	
	
	
	
	
}
