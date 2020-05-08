package com.kyho.blog.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
	
	
	@GetMapping("/all")
	public String Hello() {
		return "Hello";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value = "/private")
	public String privateArea() {
		return "private";
	}
	
}
