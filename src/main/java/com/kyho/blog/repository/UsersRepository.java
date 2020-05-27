package com.kyho.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyho.blog.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

	User findByName(String username);
	
	

}
