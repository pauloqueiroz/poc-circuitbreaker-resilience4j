package br.com.example.pokedex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.example.pokedex.kanto.client.KantoClient;

@Service	
public class PokedexService {

	KantoClient kantoClient;
	
	@Autowired
	public PokedexService(KantoClient kantoClient) {
		this.kantoClient = kantoClient;
	}

	public ResponseEntity<?> getKantoData(){
		var kantoData = kantoClient.retrieveKantoData();
		return ResponseEntity.ok(kantoData.toString());
	}
}
