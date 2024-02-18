package br.com.example.kantoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.kantoservice.record.RegionRecord;
import br.com.example.kantoservice.service.KantoService;

@RestController
public class KantoController {

	private KantoService service;
	
	@Autowired
	public KantoController(KantoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/details")
	public RegionRecord getRegionDetails() {
		return service.getRegionDetails();
	}
}
