package com.skillstorm.project4.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "BGINFO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BgInfo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BGINFO_ID")
	private int id;
	@Column(name = "PHONE_NUMBER", nullable = false, length = 20)
	private String phoneNumber;
	@Column(name = "BIRTHDAY", nullable = false, length = 10)
	private String birthday;
	// dropdown of options
	@Column(name = "GENDER", nullable = false)
	private String gender;
	// @Column(name = "ACCOUNT_ID", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;

	public BgInfo() {
	}

	public BgInfo(String phoneNumber, String birthday, String gender,
			Account account) {
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.gender = gender;
		this.account = account;
	}

	public BgInfo(int id, String phoneNumber, String birthday, String gender,
			Account account) {
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.gender = gender;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
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
		BgInfo other = (BgInfo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BgInfo [account=" + account + ", birthday=" + birthday + ", gender="
				+ gender + ", id=" + id + ", phoneNumber=" + phoneNumber + "]";
	}

}
