package com.springboot.iKub.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springboot.iKub.Entity.User;
import com.springboot.iKub.utils.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	String getLoggedUserEmail();
	
    User findByEmail(String email);
    
    User save(UserRegistrationDto registration);
}