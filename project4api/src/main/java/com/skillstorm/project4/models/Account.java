package com.skillstorm.project4.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ACCOUNT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private int id;
	@Column(name = "FIRST_NAME", nullable = false, length = 50)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false, length = 50)
	private String lastName;
	@Column(name = "PASSWORD", nullable = false, length = 64)
	private String password;
	@Column(name = "EMAIL", nullable = false, unique = true, length = 100)
	private String email;
	//@Column(name = "CREATED", nullable = false, length = 10)
	//private String created;
	@Column(name = "BGCOLOR", nullable = false, length = 10)
	private String bgColor;
	@Column(name = "AVATAR", nullable = true, length = 50)
	private String avatar;
	// private Boolean isAdmin;
	//@Column(name = "COLLABORATORS", nullable = true)
	//private Set<Account> account;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@JsonIgnore
	private Set<BgInfo> bgInfo;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@JsonIgnore
	private Set<Goal> goal;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@JsonIgnore
	private Set<Notification> notification;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@JsonIgnore
	private Set<Transaction> transaction;

	public Account() {
		this.bgColor = "";
	}

	public Account(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.bgColor = "";
	}



	public Account(int id, String firstName, String lastName, String password, String email,
			String bgColor, String avatar, Set<BgInfo> bgInfo, Set<Goal> goal, Set<Notification> notification,
			Set<Transaction> transaction) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.bgColor = "";
		this.avatar = avatar;
		this.bgInfo = bgInfo;
		this.goal = goal;
		this.notification = notification;
		this.transaction = transaction;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

//	public Set<Account> getAccount() {
//		return account;
//	}
//
//	public void setAccount(Set<Account> account) {
//		this.account = account;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	public Set<BgInfo> getBgInfo() {
		return bgInfo;
	}

	public void setBgInfo(Set<BgInfo> bgInfo) {
		this.bgInfo = bgInfo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", bgColor=" + bgColor + ", avatar=" + avatar
				+ ", bgInfo=" + bgInfo + ", goal=" + goal + ", notification=" + notification + ", transaction="
				+ transaction + "]";
	}



}
