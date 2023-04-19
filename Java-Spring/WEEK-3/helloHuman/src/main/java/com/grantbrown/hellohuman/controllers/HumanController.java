package com.grantbrown.hellohuman.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	@RequestMapping("/")
	public String home() {
		return "Hello Human";
	}
	@RequestMapping("/name")
	public String homeName() {
		return "Hello Human";
	}
	@RequestMapping("/name/{userFirst}/{userLast}")
	public String greetName(
			@PathVariable("userFirst") String userFirst,
			@PathVariable("userLast") String userLast) {
		return "Hello " + userFirst + " " + userLast;
	}
}
