package br.com.example.kantoservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.example.kantoservice.record.PokemonRecord;
import br.com.example.kantoservice.record.RegionRecord;

@Service
public class KantoService {

	public RegionRecord getRegionDetails() {
		var bulbasaur = new PokemonRecord(1, "Bulbasaur", "Planta");
		var charmander = new PokemonRecord(4, "Charmander", "Fogo");
		var squirtle = new PokemonRecord(7, "Squirtle", "Água");
		var pikachu = new PokemonRecord(25, "Pikachu", "Elétrico");
		
		List<PokemonRecord> pokemons = Arrays.asList(bulbasaur, charmander, squirtle, pikachu);

        return new RegionRecord("Kanto", pokemons);
	}
}
