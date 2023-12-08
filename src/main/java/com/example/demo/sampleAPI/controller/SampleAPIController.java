package com.example.demo.sampleAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.sampleAPI.data.Animals;
import com.example.demo.sampleAPI.service.SampleAPIService;

@Controller
public class SampleAPIController {

	private final SampleAPIService sampleAPIService;

	public SampleAPIController(SampleAPIService sampleAPIService) {
		this.sampleAPIService = sampleAPIService;
	}

	@GetMapping("/sampleAPI")
	//Modelオブジェクトはビューにデータを渡すためのコンテナ。ここではanimalsListをモデルに追加してる。
	//getPetsメソッドはAnimalsAPIServiceを通じて外部APIからデータを取得し、その結果をモデルに追加する。
	public String getPets(Model model) throws IOException {
		//animalsAPIService.getAnimals()を呼び出して、SampleAPIServiceを介して外部APIからデータを取得。
		//取得されたデータはList<Animals>型のanimalsListに格納される。
		List<Animals> animalsList = sampleAPIService.getAnimals();
		//ModelにanimalsListを追加することでHTMLテンプレートないでanimalListという名前を使用してデータにアクセスできるようにする。
		model.addAttribute("animalsList", animalsList);

		return "sampleAPI.html";

	}

}
