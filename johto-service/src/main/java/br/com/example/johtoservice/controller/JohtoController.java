package br.com.example.johtoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.johtoservice.record.RegionRecord;
import br.com.example.johtoservice.service.JohtoService;

@RestController
public class JohtoController {
	
	JohtoService service;
	
	@Autowired
	public JohtoController(JohtoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/details")
	public RegionRecord getRegionDetails() {
		return service.getRegionDetails();
	}
	
}
