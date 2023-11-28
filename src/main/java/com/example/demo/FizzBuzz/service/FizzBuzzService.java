package com.example.demo.FizzBuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

	public List<String> FizzBuzz(int minNumber, int maxNumber) {
		List<String> numbers = new ArrayList<>();

		for (int i = minNumber; i <= maxNumber; i++) {

			if (i % 3 == 0 && i % 5 == 0) {
				numbers.add("FizzBuzz");
			} else if (i % 3 == 0) {
				numbers.add("Fizz");
			} else if (i % 5 == 0) {
				numbers.add("Buzz");
			} else {
				numbers.add(Integer.toString(i));
			}
		}
		return numbers;

	}

}
