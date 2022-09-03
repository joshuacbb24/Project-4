package com.skillstorm.project4.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.skillstorm.project4.models.Account;
import com.skillstorm.project4.respositories.AccountRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Test
    public void testCreateAccount() {
    	Account account = new Account();
    	account.setEmail("pat@gmail.com");
    	account.setPassword("password");
    	account.setFirstName("Patrick");
    	account.setLastName("Star");
    	
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	String encodedPassword = encoder.encode(account.getPassword());
    	account.setPassword(encodedPassword);
    	
    	// create object of Random class
    	Random obj = new Random();
    	int rand_num = obj.nextInt(0xffffff + 1);
    	
    	// format it as hexadecimal string and print
    	String colorCode = String.format("#%06x", rand_num);
    	account.setBgColor(colorCode);
    	
    	Account savedAccount = accountRepository.save(account);
    	
    	Account existAccount = entityManager.find(Account.class, savedAccount.getId());
    	
    	assertThat(existAccount.getEmail()).isEqualTo(account.getEmail());
    }
    
    @Test
    public void testFindAccountByEmail() {
    	String email = "ss@gmail.com";
    	
    	Account account = accountRepository.findByEmail(email);
    	
    	assertThat(account).isNotNull();
    }
}
