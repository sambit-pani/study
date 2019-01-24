package com.example.rest.webservice.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	MessageSource messageSource;

	@GetMapping("hello")
	public String hello() {
		messageSource.getMessage("message",null, LocaleContextHolder.getLocale());
		return "hello";
	}
}
