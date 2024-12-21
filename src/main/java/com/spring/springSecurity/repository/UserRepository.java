package com.spring.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.springSecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

}