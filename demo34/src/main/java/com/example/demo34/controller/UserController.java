package com.example.demo34.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo34.dao.UserRepository;
import com.example.demo34.model.User;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public Object userLogin(@RequestBody User user) {
		User u = repository.findUserByEmail(user.getEmail());
		// Map<String, Object> map = new HashMap<>();
		if (u != null) {
			if (passwordEncoder.matches(user.getPassword(), u.getPassword())) {
				if (u.getEmail().equals(user.getEmail())) {
					u.setLastLoginTime(new Date());
					repository.save(u);
					return "Hey! " + u.getName() + " is Login Successfully.";
				}
			} else {
				return "try again!, Invalid Password.";
			}
		} else {
			return "try again!, Invalide Email";
		}
		return null;
	}

	@PostMapping("/register")
	public Object register(@RequestBody User user) {
		if (repository.existsByEmail(user.getEmail())) {
			return "this email already exists.";
		}
		if (repository.existsByPassword(user.getPassword())) {
			return "this password already exists";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreatedAt(new Date());
		repository.save(user);
		return "Hi " + user.getName() + " your Registration process successfully completed";
	}

	@GetMapping("/getAllUsers")
	public List<User> findAllUsers() {
		return repository.findAll();
	}

	@GetMapping("/findUser/{email}")
	public List<User> findUser(@PathVariable String email) {
		return repository.findByEmail(email);
	}

	@DeleteMapping("/cancel/{id}")
	public List<User> cancelRegistration(@PathVariable int id) {
		repository.deleteById(id);
		return repository.findAll();
	}
}
