package com.example.demo.AnimalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AnimalsAPI.data.Animals;
import com.example.demo.AnimalsAPI.repository.AnimalsAPIRepository;

@Service
public class AnimalsAPIService {
	private final AnimalsAPIRepository animalsAPIRepository;

	public AnimalsAPIService(AnimalsAPIRepository animalsAPIRepository) {
		this.animalsAPIRepository = animalsAPIRepository;
	}

	public List<Animals> getAnimals() throws IOException {
		try {
			Animals[] animalsList = animalsAPIRepository.getAnimals();
			return Arrays.asList(animalsList);
		} catch (IOException e) {
			throw new IOException("データ取得中にエラー", e);
		}

	}

	public List<Animals> getAnimal(int index) throws IOException {
		try {
			Animals[] animal = animalsAPIRepository.getAnimal(index);
			return Arrays.asList(animal);
		} catch (IOException e) {
			throw new IOException("データ取得中にエラー", e);
		}

	}
}
