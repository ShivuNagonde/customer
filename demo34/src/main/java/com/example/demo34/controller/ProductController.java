package com.example.demo34.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo34.dao.ProductRepository;
import com.example.demo34.model.Product;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/addProduct")
	public Object addProduct(@RequestBody Product product) {
		productRepository.save(product);
		return "Product Added Successfully.";
	}

	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/getAllProducts/{id}")
	public List<Product> getProductById(@PathVariable("id") int id) {
		return productRepository.findById(id);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public List<Product> deleteProductById(@PathVariable("id") int id) {
		productRepository.deleteById(id);
		return productRepository.findAll();
	}
}
