package br.com.example.kantoservice.repository;

import br.com.example.kantoservice.pokemon.PokemonRecord;
import br.com.example.kantoservice.pokemon.PokemonType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PokemonRepository {

    private static List<PokemonRecord> pokemons = Arrays.asList(new PokemonRecord(1, "Bulbasaur", PokemonType.PLANTA),
                                                                new PokemonRecord(4, "Charmander", PokemonType.FOGO),
                                                                new PokemonRecord(7, "Squirtle", PokemonType.AGUA),
                                                                new PokemonRecord(25, "Pikachu", PokemonType.ELETRICO));

    public List<PokemonRecord> findAll(){
        return pokemons;
    }

}
