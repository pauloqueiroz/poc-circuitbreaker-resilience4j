package br.com.example.kantoservice.record;

import java.util.List;

public record RegionRecord(String region, List<PokemonRecord> pokemons) {} 
