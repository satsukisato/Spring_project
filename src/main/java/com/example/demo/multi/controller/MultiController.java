package com.example.demo.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.multi.service.MultiService;

@Controller
public class MultiController {
	//定数サービスクラスの変更は移行無しMultiServiceの定義
	private final MultiService multiService;

	public MultiController(MultiService multiService) {
		this.multiService = multiService;
	}

	@GetMapping("multi")
	public String plus(Model model) {
		
		String result = "";

		result = String.valueOf(multiService.multi(5, 6));

		model.addAttribute("result", result);
		
		return "multi.html";
	}
}
