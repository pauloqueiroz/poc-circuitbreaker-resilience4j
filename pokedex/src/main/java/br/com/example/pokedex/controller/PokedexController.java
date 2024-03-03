package br.com.example.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.pokedex.service.PokedexService;

@RestController
public class PokedexController {
	
	PokedexService service;

	@Autowired
	public PokedexController(PokedexService service) {
		this.service = service;
	}


	@GetMapping("/kanto")
	public ResponseEntity<?> getKantoPokedex(){
		return service.getKantoData();
	}
	
}
