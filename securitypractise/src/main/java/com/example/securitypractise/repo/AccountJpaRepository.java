package com.example.securitypractise.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securitypractise.entity.Account;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long>{

	public Optional<Account> findByUsername(String name);
	
	public boolean existsByUsername(String name);
	
	public boolean existsByEmail(String email);
	
}
