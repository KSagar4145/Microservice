package com.lced.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lced.user.service.entities.User;
import com.lced.user.service.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getSingleUser(@PathVariable String userId) {
		System.err.println(">>>>>>>>>>>>>>>>>>>>");
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
	}

	@GetMapping
	public ResponseEntity<?> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
	}

}
