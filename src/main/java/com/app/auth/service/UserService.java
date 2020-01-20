package com.app.auth.service;

import com.app.auth.model.User;

public interface UserService {
	void save(User user);
    User findByUsername(String username);
}
