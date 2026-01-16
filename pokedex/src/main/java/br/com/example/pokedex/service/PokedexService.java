package br.com.example.pokedex.service;

import br.com.example.pokedex.RegionClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service	
public class PokedexService {

	private static final Logger LOG = LogManager.getLogger(PokedexService.class);

	private final RegionResolver regionResolver;
	
	@Autowired
	public PokedexService(RegionResolver regionResolver) {
		this.regionResolver = regionResolver;
	}

	public ResponseEntity<?> getRegionData(String region){
		LoggerContext context = LogManager.getContext();
		LOG.info("Regiao buscada: "+region);
		LOG.warn("Warning - Regiao buscada: "+region);
		LOG.error("Error - Regiao buscada: "+region);
		LOG.info(context.toString());
        RegionClient client = regionResolver.getRegionClient(region);
        var regionData = client.retrieve();
		return ResponseEntity.ok(regionData.toString());
	}

	public ResponseEntity<?> getRegionData(String regionName, ProxyExchange<byte[]> proxy) {
        return proxy.get();
	}
}
