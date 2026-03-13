package com.user_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user_service.entity.UserInformation;

public interface UserJpaRepository extends JpaRepository<UserInformation, String>{

}
