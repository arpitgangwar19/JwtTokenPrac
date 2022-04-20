package com.prac.jwt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prac.jwt.model.User;
import com.prac.jwt.repository.UserRepository;

@SpringBootApplication
public class JwtApplication {

	@Autowired
	UserRepository userRepo;

	@PostConstruct
	public void addUser() {

//		User user = new User(1,"Arpit","1234","abv");
		List<User> users = Stream
				.of(new User(1, "Arpit", "1234", "abv"), new User(1, "Shiv", "1234", "abv"),
						new User(1, "Shivam", "1234", "abv"), new User(1, "Shiva", "1234", "abv"))
				.collect(Collectors.toList());
		userRepo.saveAll(users);
		System.out.print("working");
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
