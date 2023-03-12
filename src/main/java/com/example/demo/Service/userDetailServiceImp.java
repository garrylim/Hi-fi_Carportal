package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Entity.User;

public class userDetailServiceImp implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("user not found.");
		}
		
		return new CustomUserDetails(user);
	}
}