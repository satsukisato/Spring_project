package com.example.demo.sampleAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.sampleAPI.data.Animals;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class SampleAPIRepository {

	public Animals[] getAnimals() throws IOException {

		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi";
		//インスタンス化,RestTemplateクラスはSpringが提供するHTTPリクエストを行うためのクラスで、APIへのGETリクエストを送るために使う。
		RestTemplate rest = new RestTemplate();
		//RestTemplate(rest)を使用してAPIにGETリクエストを送り、その結果をResponseEntity<String>で取得している。
		ResponseEntity<String> response = rest.getForEntity(url, String.class);
		//取得したレスポンスからJSONデータを取り出す。
		String json = response.getBody();
		//ObjectMapperクラスはjacksonライブラリの中心的なクラス、JSONデータをjavaオブジェクトの変換を担当。
		ObjectMapper mapper = new ObjectMapper();
		//readValueメソッドはJSONデータを指定されたデータ型（Animals[].classで指定した型）のオブジェクトに変換する。
		//Jacksonを使用して外部APIから受け取ったJSONデータをjavaオブジェクト（Animalsクラスの配列）に変換してる。
		Animals[] animalsList = mapper.readValue(json, Animals[].class);

		return animalsList;
	}

}
