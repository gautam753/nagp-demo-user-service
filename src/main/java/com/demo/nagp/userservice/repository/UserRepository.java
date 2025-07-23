package com.demo.nagp.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.nagp.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
