package com.kyho.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyho.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	

}
