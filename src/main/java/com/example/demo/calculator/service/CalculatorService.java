package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int plus(int number1, int number2) {
		return number1 + number2;
	}

	public int minus(int number1, int number2) {
		return number1 - number2;
	}

	public int multi(int number1, int number2) {
		return number1 * number2;

	}

	public double divide(int number1, int number2) {
			return (double) number1 / number2;
	}
}
