package com.itsol.bank.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itsol.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	@Query(value = "Select id from account where email = ?1", nativeQuery = true)
	Long checkAccountByEmail(String email);
	
	@Query(value = "Select id from account where account_number = ?1", nativeQuery = true)
	Long checkAccountByAccountNum(Long account_number);
	
	@Query(value = "Select * from account where gender LIKE ?1 or account_number = ?1 or firstname LIKE ?1 or lastname LIKE ?1 or address LIKE ?1 or balance = ?1 or city LIKE ?1 or employer LIKE ?1 or state LIKE ?1 or age = ?1 or email LIKE ?1", nativeQuery = true)
	Page<Account> searchByAllField(String keyword, Pageable pageable);
}
