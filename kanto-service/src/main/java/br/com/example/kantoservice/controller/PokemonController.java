package br.com.example.kantoservice.controller;

import br.com.example.kantoservice.dto.PokemonDto;
import br.com.example.kantoservice.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/pokemon")
@RestController
public class PokemonController {

    private final PokemonRepository repository;

    @Autowired
    public PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PokemonDto> getPokemons(){
        return repository.findAll().stream().map(PokemonDto::new).toList();
    }
}
