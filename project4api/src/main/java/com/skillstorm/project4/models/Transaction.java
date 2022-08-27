package com.skillstorm.project4.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TRANSACTION")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANSACTION_ID")
	private int id;
	@Column(name = "AMOUNT", nullable = false)
	private long amount;
	@OneToOne
	private Account fromAccount;
	@ManyToOne
	@JoinColumn(name = "GOAL_ID", nullable = false)
	private Goal goal;

}
