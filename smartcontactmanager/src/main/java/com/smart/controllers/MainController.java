package com.smart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String homeController(Model model) {
		model.addAttribute("title","Home - Smart Contact Manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String aboutController(Model model) {
		model.addAttribute("title","About - Smart Contact Manager");
		return "about";
	}
	
	@GetMapping("/signup")
	public String signupController(Model model) {
		model.addAttribute("title","Register - Smart Contact Manager");
		return "signup";
	}
}
