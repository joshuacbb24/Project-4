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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ACCOUNT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private int id;
	@Column(name = "PASSWORD", nullable = false, length = 64)
	private String password;
	@Column(name = "EMAIL", nullable = false, unique = true, length = 100)
	private String email;
	@Column(name = "CREATED", nullable = false, length = 10)
	private String created;
	@Column(name = "BGCOLOR", nullable = false, length = 10)
	private String bgColor;
	@Column(name = "AVATAR", nullable = true, length = 50)
	private String avatar;
	// private Boolean isAdmin;
	//@Column(name = "COLLABORATORS", nullable = true)
	//private Set<Account> account;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<BgInfo> bgInfo;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Goal> goal;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Notification> notification;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Transaction> transaction;

	public Account() {
		this.bgColor = "1";
	}

	public Account(String password, String email, String created, String avatar) {
		this.password = password;
		this.email = email;
		this.created = created;
		this.avatar = avatar;
		this.bgColor = "";
	}

	public Account(String password, String email, String created, String avatar, Set<Account> account) {
		this.password = password;
		this.email = email;
		this.created = created;
		this.bgColor = "bgColor";
		this.avatar = avatar;
		//this.account = account;
	}

	public Account(int id, String password, String email, String created, String bgColor, String avatar,
			Set<Account> account) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.created = created;
		this.bgColor = bgColor;
		this.avatar = avatar;
		//this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
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
		return "Account [avatar=" + avatar + ", bgColor=" + bgColor + ", created=" + created
				+ ", email=" + email + ", id=" + id + ", password=" + password + "]";
	}

}
