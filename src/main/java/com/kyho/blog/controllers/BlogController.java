package com.kyho.blog.controllers;

import java.util.Date;
import java.util.List;

import com.kyho.blog.entities.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.kyho.blog.entities.Post;
import com.kyho.blog.entities.User;
import com.kyho.blog.service.PostService;
import com.kyho.blog.service.UserService;
import sun.plugin.liveconnect.SecurityContextHelper;

@RestController
public class BlogController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	
	@GetMapping(value = "/users")
	public List<User> users() {
		return userService.getAllUsers();
	
	}
	
	@GetMapping("/all")
	public String Hello() {
		return "Hello";
	}
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping(value = "/private")
	public String privateArea() {
		return "private";
	}
	
	@GetMapping(value = "/posts")
	public List<Post> posts() {
		return postService.getAllPosts();
	}

	@PreAuthorize("hasAnyRole('USER')")
	@PostMapping(value="/post")
	public String publishPost(@RequestBody Post post) {

		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		//CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(post.getDateCreated() == null) {
			post.setDateCreated(new Date());
		}
		post.setCreator(userService.getUser(loggedInUser.getName()));

		if (postService.findByPostId(post.getPostId()) == null) {
			postService.insert(post);
		} else {
			postService.modify(post);
		}


		return "Post was published";
	}

	@GetMapping(value = "/posts/{username}")
	public List<Post> postByUsername(@PathVariable String username) {
		return postService.findByUsername(userService.getUser(username));
	}

	@PostMapping(value = "/delete")
	public String delete(@RequestBody Post post) {
		System.out.println(post.getPostId());
		postService.deleteByPostId(post.getPostId());
		return "Post deleted";
	}
}
