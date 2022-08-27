package com.skillstorm.project4.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "GOAL")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GOAL_ID", nullable = false)
	private int id;
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	@Column(name = "START_DATE", nullable = false, length = 10)
	private String startDate;
	@Column(name = "END_DATE", nullable = false, length = 10)
	private String endDate;
	@ManyToMany
	private Account account;
	@Column(name = "TARGET_GOAL", nullable = false)
	private long targetGoal;
	@Column(name = "CURRENT_AMOUNT", nullable = false)
	private long currentAmount;
	@OneToMany(mappedBy = "goal")
	private Set<Transaction> transaction;

}
