package com.example.demo34.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo34.dao.CustomerRepository;
import com.example.demo34.exception.ResourceNotFoundException;
import com.example.demo34.model.Customer;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@PostMapping("/customers")
	public Object addCustomer(@RequestBody Customer customer) {
		if (repository.existsByEmail(customer.getEmail())) {
			return "this email already exists.";
		}
		customer.setCreatedAt(new Date());
		repository.save(customer);
		return "Customer added successfully.";
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

	@GetMapping("/customers/{id}")
	public Object getCustomerById(@PathVariable(value = "id") int id) {
		Optional<Customer> customer = repository.findById(id);
		if (customer.isPresent()) {
			return repository.findById(id);
		} else {
			return "Customer not found for this id : " + id;
		}
	}

	@GetMapping("/findCustomer/{email}")
	public List<Customer> findCustomer(@PathVariable("email") String email) {
		return repository.findByEmail(email);

	}

	@PutMapping("/customers/{id}")
	public Object updateCustomer(@PathVariable(value = "id") int id, @RequestBody Customer customerDetails) {
		Optional<Customer> c = repository.findById(id);
		if (c.isPresent()) {
			Customer customer = c.get();
			customer.setCustomerName(customerDetails.getCustomerName());
			customer.setContactPersonName(customerDetails.getContactPersonName());
			customer.setEmail(customerDetails.getEmail());
			customer.setMobileNo(customerDetails.getMobileNo());
			customer.setAddress(customerDetails.getAddress());
			customer.setProductName(customerDetails.getProductName());
			repository.save(customer);
			return "Customer updated successfully.";
		} else {
			return "Customer not found for this id : " + id;
		}
	}

	@DeleteMapping("/customers/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
		Customer customer = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));

		repository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
