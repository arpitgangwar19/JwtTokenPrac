package com.prac.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prac.jwt.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUsername(String username);

	User findByusername(String username);

}
