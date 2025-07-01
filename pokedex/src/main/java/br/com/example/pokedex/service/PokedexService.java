package br.com.example.pokedex.service;

import br.com.example.pokedex.kanto.client.KantoClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service	
public class PokedexService {

	private static final Logger LOG = LogManager.getLogger("Log4JCore");

	KantoClient kantoClient;
	
	@Autowired
	public PokedexService(KantoClient kantoClient) {
		this.kantoClient = kantoClient;
	}

	@CircuitBreaker(name="kantoService")
	public ResponseEntity<?> getRegionData(String region){
		LOG.info("Regiao buscada: "+region);
		LOG.warn("Warning - Regiao buscada: "+region);
		LOG.error("Error - Regiao buscada: "+region);
		var kantoData = kantoClient.retrieveKantoData();
		return ResponseEntity.ok(kantoData.toString());
	}

	public ResponseEntity<?> getRegionData(String regionName, ProxyExchange<byte[]> proxy) {
		var kantoData = kantoClient.retrieveKantoData();
		return ResponseEntity.ok(kantoData.toString());
	}
}
