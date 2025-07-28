package com.demo.nagp.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.nagp.userservice.entity.User;
import com.demo.nagp.userservice.model.CommonResponseModel;
import com.demo.nagp.userservice.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService service;
	String podName = System.getenv("HOSTNAME");

	@GetMapping
	public CommonResponseModel getAllUsers() {
		return service.getAllUsers();
	}

	@PostMapping
	public CommonResponseModel createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CommonResponseModel> getUserById(@PathVariable Long id) {
		return service.getUserById(id)
				.map(user -> ResponseEntity.ok(CommonResponseModel.builder().podName(podName).userDetail(user).build()))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<CommonResponseModel> updateUser(@PathVariable Long id, @RequestBody User user) {
		return ResponseEntity.ok(service.updateUser(id, user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
