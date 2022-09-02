package com.skillstorm.project4.models;

import java.io.Serializable;
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
	@Column(name = "START_DATE", nullable = false, length = 10)
	private String startDate;
	@Column(name = "END_DATE", nullable = false, length = 10)
	private String endDate;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ACCOUNT_GOAL", joinColumns = { @JoinColumn(name = "ACCOUNT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "GOAL_ID") })
	private Set<Account> account;
	@Column(name = "TARGET_GOAL", nullable = false)
	private float targetGoal;
	@Column(name = "CURRENT_AMOUNT", nullable = false)
	private float currentAmount;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "goal")
	private Set<Transaction> transaction;

	public Goal() {
	}

	public Goal(String name, String startDate, String endDate, Set<Account> account, float targetGoal, float currentAmount) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.account = account;
		this.targetGoal = targetGoal;
		this.currentAmount = currentAmount;
	}

	public Goal(int id, String name, String startDate, String endDate, Set<Account> account, float targetGoal,
			long currentAmount, Set<Transaction> transaction) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
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

	public float getTargetGoal() {
		return targetGoal;
	}

	public void setTargetGoal(float targetGoal) {
		this.targetGoal = targetGoal;
	}

	public float getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(float currentAmount) {
		this.currentAmount = currentAmount;
	}

	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Goal [account=" + account + ", currentAmount=" + currentAmount + ", endDate=" + endDate + ", id=" + id
				+ ", name=" + name + ", startDate=" + startDate + ", targetGoal=" + targetGoal + ", transaction="
				+ transaction + "]";
	}

}
