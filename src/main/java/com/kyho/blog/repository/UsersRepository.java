package com.kyho.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyho.blog.entities.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByName(String username);
	
	

}
