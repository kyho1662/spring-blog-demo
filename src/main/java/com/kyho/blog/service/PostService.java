package com.kyho.blog.service;

import java.util.Date;
import java.util.List;

import com.kyho.blog.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyho.blog.entities.Post;
import com.kyho.blog.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // https://stackoverflow.com/questions/32269192/spring-no-entitymanager-with-actual-transaction-available-for-current-thread
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

    public void deleteByPostId(Long postId) {
		postRepository.deleteByPostId(postId);
    }

	public Post findByPostId(Long postId) {
		return postRepository.findByPostId(postId);
	}

	public void modify(Post post) {
		Post modifiedPost = postRepository.getOne(post.getPostId());
		modifiedPost.setTitle(post.getTitle());
		modifiedPost.setBody(post.getBody());
		modifiedPost.setDateCreated(new Date());
		postRepository.save(modifiedPost);

	}
}
