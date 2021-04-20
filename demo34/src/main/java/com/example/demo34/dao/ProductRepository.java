package com.example.demo34.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo34.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findById(int pId);

	Product findByProductName(String productName);

}
