package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;


@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	// save, update user object
	public void saveUser(User user, String roleName) {
		Role role = roleRepository.findByName(roleName);
		if (role == null) {
			role = new Role(roleName);
			roleRepository.save(role);
		}
		user.addRole(role);
		userRepository.save(user);
	}

	// update user object
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public long countRegisteredUser() {
		return userRepository.count();
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
	public User getUserById(Long user_id) {
		return userRepository.findById(user_id).orElse(null);
	}
	
	 // return all user information
	public List<User> retrieveAllUserProfile() {
		return userRepository.findAll();
	}
	
	public List<User> search(String keyword) {
		return userRepository.search(keyword);
	}
	
	public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
