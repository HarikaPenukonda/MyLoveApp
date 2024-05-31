package com.seleniumexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello"; 
	}

}
