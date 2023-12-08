package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.data.Animals;
import com.example.demo.AnimalsAPI.service.AnimalsAPIService;

@Controller
public class AnimalsAPIController {

	private final AnimalsAPIService animalsAPIService;

	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}

	@GetMapping("animalsSearch")
	public String doGet(Model model) {
		try {
			List<Animals> animalsList = animalsAPIService.getAnimals();
			//Modelオブジェクトに追加、animalsListとしてビューに渡す
			model.addAttribute("animalsList", animalsList);
			
			return "animalsSearch";
			
		} catch (IOException e) {
			e.printStackTrace();
			
			model.addAttribute("error", "動物の情報の取得に失敗しました。");
			
			return "error";
		}
	}

	@GetMapping("animalsDetail")
	//name属性で明示的にパラメータ名を指定、int型のanimalsSelectパラメータに結びつける
	public String doGet(@RequestParam(name = "animalsSelect") int selectAnimal, Model model)  {
		try {
			List<Animals> animal = animalsAPIService.getAnimal(selectAnimal);
			
			model.addAttribute("animal", animal);
			
			return "animalsDetail";
			
		} catch(IOException e) {
			e.printStackTrace();
			
			model.addAttribute("error", "動物の情報の取得に失敗しました。");
			
			return "error";
		}
	}
}