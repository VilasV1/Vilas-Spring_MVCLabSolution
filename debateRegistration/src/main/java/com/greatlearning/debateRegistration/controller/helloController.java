package com.greatlearning.debateRegistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class helloController {

	@RequestMapping("/hello")
	public String showMainPage() {
		return "demo";
	}

}
