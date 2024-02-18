package br.com.example.johtoservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.example.johtoservice.record.PokemonRecord;
import br.com.example.johtoservice.record.RegionRecord;

@Service
public class JohtoService {

	public RegionRecord getRegionDetails() {
		var chikorita = new PokemonRecord(152, "Chikorita", "Planta");
		var cyndaquil = new PokemonRecord(155, "Cyndaquil", "Fogo");
		var totodile = new PokemonRecord(158, "Totodile", "Água");
		var togepi = new PokemonRecord(175, "Togepi", "Fada");
		
		List<PokemonRecord> pokemons = Arrays.asList(chikorita, cyndaquil, totodile, togepi);
		var regionRecord = new RegionRecord("Johto", pokemons);
		
		return regionRecord;
	}
	
}
