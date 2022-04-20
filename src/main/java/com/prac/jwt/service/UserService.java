package com.prac.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.prac.jwt.dto.AuthRequest;
import com.prac.jwt.util.JwtUtil;

@Service
public class UserService {

	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	AuthenticationManager authenticationManager;

	public String authenticate(@RequestBody AuthRequest request) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		} catch (Exception e) {
			System.out.println("Invalid" + e);
			// TODO: handle exception
		}
		return jwtUtil.generateToken(request.getUsername());
	}

}
