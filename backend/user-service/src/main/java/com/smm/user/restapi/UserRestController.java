package com.smm.user.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smm.user.model.User;
import com.smm.user.repository.UserRepository;

@RestController
public class UserRestController {
	private UserRepository userRepository;

	public UserRestController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping("/v1/users/{id}")
	public User getUser(@PathVariable long id) {
		return userRepository.findById(id).orElse(null);
	}
}
