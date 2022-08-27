package com.skillstorm.project4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project4.respositories.AccountRepository;

@Service
@Transactional
public class AccountService {
    @Autowired
    public AccountRepository accountRepository;
}
