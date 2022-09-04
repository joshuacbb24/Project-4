package com.skillstorm.project4.dtos;

public class AccountDto {

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String avatar;
	
	public AccountDto() {
		super();
	}
	public AccountDto(String email, String password, String firstName, String lastName, String avatar) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avatar = avatar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "AccountDto [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", avatar=" + avatar + "]";
	}


	
	
}
