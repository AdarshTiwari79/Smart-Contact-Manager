package com.smart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private UserRepository userRepository;

	// handler for home view
	@GetMapping("/")
	public String homeController(Model model) {
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}

	// handler for about view
	@GetMapping("/about")
	public String aboutController(Model model) {
		model.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}

	// handler for registration view
	@GetMapping("/signup")
	public String signupController(Model model) {
		model.addAttribute("title", "Register - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}

	// handler for registration data comes from form field
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model, HttpSession session) {

		try {
			if (!agreement) {
				System.out.println("terms and conditions are not agreed");
				throw new Exception("You have not agreed the terms and conditions");
			}

			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");

			System.out.println("agreement : " + agreement);

			User result = userRepository.save(user);
			System.out.println("USER : " + result);

			model.addAttribute("user",new User());
			model.addAttribute("useSession", session);
			session.setAttribute("message", new Message("successfully registered !!!", "alert-success"));
			return "signup";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			model.addAttribute("useSession", session);
			session.setAttribute("message", new Message("Something went wrong !!! " + e.getMessage(), "alert-danger"));
			return "signup";
		}
		
	}

}
