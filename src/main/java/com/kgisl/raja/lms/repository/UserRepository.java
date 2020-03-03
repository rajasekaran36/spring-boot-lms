package com.kgisl.raja.lms.repository;

import com.kgisl.raja.lms.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    
}