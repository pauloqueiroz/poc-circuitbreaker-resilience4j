package br.com.example.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.pokedex.service.ConfigService;

@RestController
public class ConfigController {

	ConfigService service;
	
	@Autowired
	public ConfigController(ConfigService service) {
		super();
		this.service = service;
	}

	@GetMapping("/config/retrieve")
	public ResponseEntity<?> retrieve(){
		return service.getConfig();
	}
}
