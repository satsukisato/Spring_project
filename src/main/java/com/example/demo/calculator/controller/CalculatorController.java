package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("calculator")
	public String doGet() {
		return "calculator.html";
	}

	@PostMapping("calculator")
	public String doGet(@RequestParam("number1") String num1, @RequestParam("number2") String num2,
			@RequestParam("operation") String operation, Model model) {

		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		int result = 0;
		String message= "";

		switch (operation) {
		case "plus":
			result = calculatorService.plus(number1, number2);
			break;
		case "minus":
			result = calculatorService.minus(number1, number2);
			break;
		case "multi":
			result = calculatorService.multi(number1, number2);
			break;
		case "divide":
			try {
				result = calculatorService.divide(number1, number2);
			} catch (ArithmeticException e) {
				message = "0では割れません";
				break;
			}
		}
		
		if(message.isEmpty()) {
			model.addAttribute("answer", result);
		}else {
			model.addAttribute("errorMessage",message);
		}
		return "calculator.html";

	}

}
