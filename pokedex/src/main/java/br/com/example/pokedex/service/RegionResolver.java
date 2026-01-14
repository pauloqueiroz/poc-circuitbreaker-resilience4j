package br.com.example.pokedex.service;

import br.com.example.pokedex.JohtoClient;
import br.com.example.pokedex.RegionClient;
import br.com.example.pokedex.kanto.client.KantoClient;
import org.springframework.stereotype.Component;

@Component
public class RegionResolver {

    private KantoClient kantoClient;

    private JohtoClient johtoClient;


    private RegionClient getRegionClient(String regionName){
        RegionClient regionClient = null;
        switch (regionName){
            case "JOHTO":
                regionClient = johtoClient;
                break;
            case  "KANTO":
                regionClient = kantoClient;
            default:
                regionClient = kantoClient;
        }
        return regionClient;
    }
}
