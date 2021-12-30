package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class GreetingController {
	@GetMapping("/greeting")
	public String greeting(
			@RequestParam(name="name", required=false, defaultValue="world") String name,
			Model model) {
		model.addAttribute("name", name); //Business Logic
		return "greeting";
	}
}