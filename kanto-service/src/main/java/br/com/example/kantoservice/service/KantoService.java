package br.com.example.kantoservice.service;

import java.util.Arrays;
import java.util.List;

import br.com.example.kantoservice.pokemon.PokemonType;
import org.springframework.stereotype.Service;

import br.com.example.kantoservice.pokemon.PokemonRecord;
import br.com.example.kantoservice.pokemon.RegionRecord;

@Service
public class KantoService {

	public RegionRecord getRegionDetails() {
		var bulbasaur = new PokemonRecord(1, "Bulbasaur", PokemonType.PLANTA);
		var charmander = new PokemonRecord(4, "Charmander", PokemonType.FOGO);
		var squirtle = new PokemonRecord(7, "Squirtle", PokemonType.AGUA);
		var pikachu = new PokemonRecord(25, "Pikachu", PokemonType.ELETRICO);
		
		List<PokemonRecord> pokemons = Arrays.asList(bulbasaur, charmander, squirtle, pikachu);

        return new RegionRecord("Kanto", pokemons);
	}
}
