package br.com.example.pokedex.service;

import br.com.example.pokedex.JohtoClient;
import br.com.example.pokedex.RegionClient;
import br.com.example.pokedex.kanto.client.KantoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegionResolver {

    private final KantoClient kantoClient;

    private final JohtoClient johtoClient;

    @Autowired
    public RegionResolver(KantoClient kantoClient, JohtoClient johtoClient){
        this.kantoClient = kantoClient;
        this.johtoClient = johtoClient;
    }

    public RegionClient getRegionClient(String regionName){
        var regionUpper = regionName.toUpperCase();
        return switch (regionUpper) {
            case "JOHTO" -> johtoClient;
            default -> kantoClient;
        };
    }
}
