package br.com.example.kantoservice.dto;

import br.com.example.kantoservice.pokemon.PokemonRecord;

public record PokemonDto(String name, String type) {

    public PokemonDto(PokemonRecord pokemon){
        this(pokemon.name(), pokemon.type().toString());
    }
}
