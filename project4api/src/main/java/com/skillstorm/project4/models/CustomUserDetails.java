package com.skillstorm.project4.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private Account account;
	
	
	
	public CustomUserDetails(Account account) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return account.getPassword();
	}
	
	public String getFullName() {
		return account.getFirstName() + " " + account.getLastName();
	}
	
	public String getBackgroundColor() {
		return account.getBgColor();
	}
	
	public String getAvatar() {
		return account.getAvatar();
	}
	
	public int getId() {
		return account.getId();
	}
	
	public Account getAccount() {
		return account;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return account.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
