package br.com.example.pokedex.controller;

import br.com.example.pokedex.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokedexController {
	
	PokedexService service;

	@Autowired
	public PokedexController(PokedexService service) {
		this.service = service;
	}


	@GetMapping("region/{regionName}")
	public ResponseEntity<?> getRegionData(@PathVariable String regionName){
		return service.getRegionData(regionName);
	}

	@GetMapping("proxy-exchange/region/{regionName}")
	public ResponseEntity<?> getDataWithProxyExchange(@PathVariable String regionName, ProxyExchange<byte[]> proxy){
		return service.getRegionData(regionName, proxy);
	}
}
