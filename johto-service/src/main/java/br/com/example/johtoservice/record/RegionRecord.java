package br.com.example.johtoservice.record;

import java.util.List;

public record RegionRecord(String region, List<PokemonRecord> pokemons) {} 
