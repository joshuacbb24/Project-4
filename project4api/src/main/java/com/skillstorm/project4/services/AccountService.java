package com.skillstorm.project4.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project4.dtos.AccountDto;
import com.skillstorm.project4.exceptions.EmailExistsException;
import com.skillstorm.project4.models.Account;
import com.skillstorm.project4.respositories.AccountRepository;

@Service
@Transactional
public class AccountService {
    @Autowired
    public AccountRepository accountRepository;
    
    public List<Account> fetchAccounts(){
    	return accountRepository.findAll();
    }
    
    public Account createAccount(AccountDto accountInfo) throws EmailExistsException {
    	if (accountRepository.findByEmail(accountInfo.getEmail()) != null)
    	{
    		throw new EmailExistsException();
    	}
    	Account account = new Account();
    	account.setEmail(accountInfo.getEmail());
    	account.setFirstName(accountInfo.getFirstName());
    	account.setLastName(accountInfo.getLastName());
    	account.setAvatar(accountInfo.getAvatar());
    	
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    	String encodedPassword = encoder.encode(accountInfo.getPassword());
    	account.setPassword(encodedPassword);
    	
    	// create object of Random class
    	Random obj = new Random();
    	int rand_num = obj.nextInt(0xffffff + 1);
    	
    	// format it as hexadecimal string and print
    	String colorCode = String.format("#%06x", rand_num);
    	account.setBgColor(colorCode);
    	return accountRepository.save(account);
    	
    }
    
    public Account updateAccount(Account account) {
    	return accountRepository.save(account);
    }
    
    public void deleteAccount(String email) {
    	
    }
    
    public Account login() {
    	return null;
    }
}
