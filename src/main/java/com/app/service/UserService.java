package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.auth.util.JwtTokenUtil;
import com.app.entity.User;
import com.app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private JwtTokenUtil jwtUtil;
	
	public List<User> getAllUsers() {
		List<User> usersList = (List<User>) userRepository.findAll();
		
		return usersList.parallelStream().map(user -> {
			user.setPassword(null);
			return user;
		}).collect(Collectors.toList());
	}

	public User getCurrentUserByToken(String token) {
		String userName = jwtUtil.extractUsername(token);
		User user = userRepository.findByUsername(userName);
		user.setPassword(null);
		return user;
	}

	public User update(User user) {
		Optional<User> userOptional = userRepository.findById(Math.toIntExact(user.getId()));
		if(userOptional.isPresent()) {
			User updatedUser = userOptional.get();
			if(StringUtils.isNotBlank(user.getName())) {
				updatedUser.setName(user.getName());
			}
			if(StringUtils.isNotBlank(user.getEmail())) {
				updatedUser.setEmail(user.getEmail());
			}
			
			if(user.getMobile() != null) {
				updatedUser.setMobile(user.getMobile());
			}
			
			return updatedUser;
		}else {
			throw new IllegalArgumentException("User Not Found");
		}
	}
}