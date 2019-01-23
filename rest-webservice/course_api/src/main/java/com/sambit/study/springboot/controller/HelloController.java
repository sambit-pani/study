package com.sambit.study.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("hello")
	public String greeting() {
		return "Sambit work hard";
	}
}
