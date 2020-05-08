package com.kyho.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kyho.blog.entities.CustomUserDetails;
import com.kyho.blog.entities.Users;
import com.kyho.blog.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	 @Autowired
	 private UsersRepository usersRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Optional<Users> optionalUsers = usersRepository.findByName(username);

	    optionalUsers.orElseThrow(() ->  new UsernameNotFoundException("Username not found"));
	    return optionalUsers.map(CustomUserDetails::new).get();
	    }
}
