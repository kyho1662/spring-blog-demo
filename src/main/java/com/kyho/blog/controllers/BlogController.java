package com.kyho.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
	
	@GetMapping(value = "/private")
	public String privateArea() {
		return "private";
	}
	
}
