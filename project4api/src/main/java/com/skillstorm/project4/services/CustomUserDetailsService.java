package com.skillstorm.project4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.skillstorm.project4.models.Account;
import com.skillstorm.project4.models.CustomUserDetails;
import com.skillstorm.project4.respositories.AccountRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmail(email);
		if (account == null) {
			throw new UsernameNotFoundException("account not found");
		}
		return new CustomUserDetails(account);
	}

}
