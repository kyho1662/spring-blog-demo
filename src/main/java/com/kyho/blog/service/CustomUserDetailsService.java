package com.kyho.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kyho.blog.entities.CustomUserDetails;
import com.kyho.blog.entities.User;
import com.kyho.blog.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	 @Autowired
	 private UsersRepository usersRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = usersRepository.findByName(username);

		if (user == null)
		       throw new UsernameNotFoundException("Bad credentials!");
		
		return new org.springframework.security.core.userdetails.User(
		        user.getName(), 
		        user.getPassword(), // shall to be the already BCrypt-encrypted password
		        new CustomUserDetails(user).getAuthorities());
		}
}

