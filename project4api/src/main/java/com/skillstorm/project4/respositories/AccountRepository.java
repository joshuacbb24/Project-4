package com.skillstorm.project4.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.project4.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query("SELECT a FROM Account a WHERE a.email = ?1")
	Account findByEmail(String email);
}
