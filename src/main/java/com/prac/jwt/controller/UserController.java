package com.prac.jwt.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prac.jwt.dto.AuthRequest;
import com.prac.jwt.model.User;
import com.prac.jwt.repository.UserRepository;
import com.prac.jwt.service.UserService;
import com.prac.jwt.util.JwtUtil;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepo;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String test() {
////		User user = new User(1,"Arpit","1234","abv");
//		List<User> users = Stream.of(new User(1,"Arpit","1234","abv"),new User(1,"Shiv","1234","abv"),new User(1,"Shivam","1234","abv"),new User(1,"Shiva","1234","abv")).collect(Collectors.toList());
//		userRepo.saveAll(users);

		return "working";
	}

	@PostMapping("authenticate")
	public String generateToken(@RequestBody AuthRequest request) {

		return userService.authenticate(request);
	}

}
