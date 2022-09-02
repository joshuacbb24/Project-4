package com.skillstorm.project4.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "NOTIFICATION")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOTIFICATION_ID")
	private int id;
	@Column(name = "MESSAGE", nullable = false, length = 50)
	private String message;
	@Column(name = "DATE_CREATED", nullable = false, length = 10)
	private String dateCreated;
	// @Column(name = "ACCOUNT_ID", nullable = false)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ACCOUNT_NOTIFICATION", joinColumns = { @JoinColumn(name = "ACCOUNT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "NOTIFICATION_ID") })
	private Set<Account> account;

	public Notification() {
	}

	public Notification(String message, String dateCreated, Set<Account> account) {
		this.message = message;
		this.dateCreated = dateCreated;
		this.account = account;
	}

	public Notification(int id, String message, String dateCreated, Set<Account> account) {
		this.id = id;
		this.message = message;
		this.dateCreated = dateCreated;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
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
		Notification other = (Notification) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notification [account=" + account + ", dateCreated=" + dateCreated + ", id=" + id + ", message="
				+ message + "]";
	}

}
