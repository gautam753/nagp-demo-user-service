package com.demo.nagp.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.nagp.userservice.entity.User;
import com.demo.nagp.userservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository repo;

	public List<User> getAllUsers() {
		return repo.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return repo.findById(id);
	}

	public User createUser(User user) {
		return repo.save(user);
	}

	public User updateUser(Long id, User userDetails) {
		return repo.findById(id).map(user -> {
			user.setName(userDetails.getName());
			user.setEmail(userDetails.getEmail());
			return repo.save(user);
		}).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public void deleteUser(Long id) {
		repo.deleteById(id);
	}
}
