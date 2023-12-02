package com.example.demo.minus.service;

import org.springframework.stereotype.Service;

@Service
public class MinusService {

	public int subtractNumbers(int number1, int number2) {
		int result = number1 - number2;
		
		return result;

	}

}
