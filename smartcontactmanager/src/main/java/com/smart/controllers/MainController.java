package com.smart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/home")
	public String homeController(Model model) {
		model.addAttribute("title","Home - Smart Contact Manager");
		return "home";
	}
}
