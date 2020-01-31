package com.app.config.services;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	private final Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.debug("Getting User with Name:{}",username);
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
	
	public User save(User user) {
		if(null == user) {
			logger.error("User should not be Empty..!!!");
			throw new IllegalArgumentException("User should not be Empty..!!!");
		}
		
		logger.debug("Persisting User:{}",user.getUsername());
		
		if(StringUtils.isBlank(user.getName())){
			logger.error("Name should not be Empty..!!!");
			throw new IllegalArgumentException("Name should not be Empty..!!!");
		}
		
		if(StringUtils.isBlank(user.getPassword())){
			logger.error("Password should not be Empty..!!!");
			throw new IllegalArgumentException("Password should not be Empty..!!!");
		}
		
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
