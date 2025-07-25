package com.demo.nagp.userservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.nagp.userservice.entity.User;
import com.demo.nagp.userservice.model.CommonResponseModel;
import com.demo.nagp.userservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository repo;
	String podName = System.getenv("HOSTNAME");

	public CommonResponseModel getAllUsers() {
		return CommonResponseModel.builder().podName(podName).users(repo.findAll()).build();
	}

	public Optional<User> getUserById(Long id) {
		return repo.findById(id);
	}

	public CommonResponseModel createUser(User user) {
		return CommonResponseModel.builder().podName(podName).userDetail(repo.save(user)).build();
	}

	public CommonResponseModel updateUser(Long id, User userDetails) {
		return repo.findById(id).map(user -> {
			user.setName(userDetails.getName());
			user.setEmail(userDetails.getEmail());
			return repo.save(user);
		}).map(user -> CommonResponseModel.builder().podName(podName).userDetail(user).build())
		.orElseThrow(() -> new RuntimeException("User not found"));
	}

	public void deleteUser(Long id) {
		repo.deleteById(id);
	}
}
