package com.smart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user", method=RequestMethod.GET)
public class UserController {
	
	@GetMapping("/dashboard")
	public String dashboardHandler() {
		
		return "index";
	}

}
