package com.example.demo34.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo34.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);

	User findUserByEmail(String email);

	boolean existsByEmail(String email);

	boolean existsByPassword(String password);

}
