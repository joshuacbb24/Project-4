package com.skillstorm.project4.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "GOAL")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Goal implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GOAL_ID", nullable = false)
	private int id;
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	@Column(name = "END_DATE", nullable = false, length = 10)
	private String endDate;
	@Column(name = "DESCRIPTION", nullable = true, length = 100)
	private String description;
	//@Column(name = "FAVORITED", nullable = false)
	//private int favorited;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ACCOUNT_GOAL", joinColumns = { @JoinColumn(name = "GOAL_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ACCOUNT_ID") })
	private Set<Account> account;
	@Column(name = "TARGET_GOAL", nullable = false)
	private BigDecimal targetGoal;
	@Column(name = "CURRENT_AMOUNT", nullable = false)
	private BigDecimal currentAmount;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "goal")
	private Set<Transaction> transaction;

	public Goal() {
	}



	public Goal(String name, String endDate, String description, BigDecimal targetGoal) {
		super();
		this.name = name;
		this.endDate = endDate;
		this.description = description;
		this.targetGoal = targetGoal;
	}



	public Goal(String name, String endDate, Set<Account> account, BigDecimal targetGoal,
			BigDecimal currentAmount) {
		super();
		this.name = name;
		this.endDate = endDate;
		this.account = account;
		this.targetGoal = targetGoal;
		this.currentAmount = currentAmount;
	}



	public Goal(String name, String endDate, String description, Set<Account> account,
			BigDecimal targetGoal) {
		super();
		this.name = name;
		this.endDate = endDate;
		this.description = description;
		this.account = account;
		this.targetGoal = targetGoal;
	}



	public Goal(String name, String endDate, String description, Set<Account> account,
			BigDecimal targetGoal, BigDecimal currentAmount) {
		super();
		this.name = name;
		this.endDate = endDate;
		this.description = description;
		this.account = account;
		this.targetGoal = targetGoal;
		this.currentAmount = currentAmount;
	}



	public Goal(int id, String name, String endDate, String description, Set<Account> account,
			BigDecimal targetGoal, BigDecimal currentAmount, Set<Transaction> transaction) {
		super();
		this.id = id;
		this.name = name;
		this.endDate = endDate;
		this.description = description;
		this.account = account;
		this.targetGoal = targetGoal;
		this.currentAmount = currentAmount;
		this.transaction = transaction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}

	public BigDecimal getTargetGoal() {
		return targetGoal;
	}

	public void setTargetGoal(BigDecimal targetGoal) {
		this.targetGoal = targetGoal;
	}

	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}

	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goal other = (Goal) obj;
		return id == other.id;
	}



	@Override
	public String toString() {
		return "Goal [id=" + id + ", name=" + name + ", endDate=" + endDate + ", description=" + description
				+ ", account=" + account + ", targetGoal=" + targetGoal + ", currentAmount=" + currentAmount
				+ ", transaction=" + transaction + "]";
	}












}
