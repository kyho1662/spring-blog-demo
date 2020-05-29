package com.kyho.blog.service;

import java.util.List;

import com.kyho.blog.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kyho.blog.entities.User;
import com.kyho.blog.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	private UsersRepository repo;
	
	public List<User> getAllUsers() {
		return repo.findAll();
	}


	public User getUser(String username) {
		return repo.findByName(username);
	}

	public void save(User user) {
		user.setPassword(getPasswordEncoder().encode(user.getPassword()));
		repo.save(user);
	}

	private PasswordEncoder getPasswordEncoder() {

		return new PasswordEncoder() {

			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				// TODO Auto-generated method stub

				System.out.println(rawPassword);
				System.out.println(encodedPassword);

				return encode(rawPassword).equals(encodedPassword);
			}
		};
	}
}
