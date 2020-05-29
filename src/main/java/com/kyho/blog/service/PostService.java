package com.kyho.blog.service;

import java.util.List;

import com.kyho.blog.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyho.blog.entities.Post;
import com.kyho.blog.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post>getAllPosts() {
		return postRepository.findAll();
	}


	public void insert(Post post) {
	    postRepository.save(post);
	}

	public List<Post> findByUsername(User user) {
		return postRepository.findByCreatorUserId(user.getUserId());
	}
}
