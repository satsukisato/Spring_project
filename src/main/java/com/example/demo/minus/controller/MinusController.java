package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {
	private final MinusService minusService;

	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}

	@GetMapping("minus")
	public String doGet() {
		return "minus.html";
	}

	@PostMapping("minus")
	public String doGet(@RequestParam("number1") String num1, @RequestParam("number2") String num2, Model model) {
		
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		int result = minusService.subtractNumbers(number1, number2);
		
		model.addAttribute("result", result);
		return "minus.html";
	}

}
