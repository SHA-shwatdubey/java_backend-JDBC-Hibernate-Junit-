package com.example.springmvcboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmvcboot.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	 Users findByEmailAndPassword(String email, String password);
}
