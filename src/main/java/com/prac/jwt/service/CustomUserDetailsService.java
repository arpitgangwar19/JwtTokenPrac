package com.prac.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prac.jwt.model.User;
import com.prac.jwt.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	List<User> users = Stream
			.of(new User(1, "Arpit", "1234", "abv"), new User(1, "Shiv", "1234", "abv"),
					new User(1, "Shivam", "1234", "abv"), new User(1, "Shiva", "1234", "abv"))
			.collect(Collectors.toList());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

//		User user = userRepo.findByUsername(username);

//		User user1 = userRepo.findByusername(username);

		User fakeUser = users.stream().filter(e -> e.getUsername().equals(username)).findAny().orElse(null);
//		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
		return new org.springframework.security.core.userdetails.User(fakeUser.getUsername(), fakeUser.getPassword(),
				new ArrayList<>());
	}

}
