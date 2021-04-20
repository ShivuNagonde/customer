package com.example.demo34.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo34.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	boolean existsByEmail(String email);

	List<Customer> findByEmail(String email);

}
