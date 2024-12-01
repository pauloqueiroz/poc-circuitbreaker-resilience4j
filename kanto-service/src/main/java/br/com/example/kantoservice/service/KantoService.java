package br.com.example.kantoservice.service;

import br.com.example.kantoservice.pokemon.PokemonRecord;
import br.com.example.kantoservice.pokemon.RegionRecord;
import br.com.example.kantoservice.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KantoService {

	private final PokemonRepository repository;

	@Autowired
    public KantoService(PokemonRepository repository) {
        this.repository = repository;
    }

    public RegionRecord getRegionDetails() {
		List<PokemonRecord> pokemons = repository.findAll();

        return new RegionRecord("Kanto", pokemons);
	}
}
