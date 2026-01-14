package br.com.example.pokedex;

import com.fasterxml.jackson.databind.JsonNode;

public interface RegionClient {
    JsonNode retrieve();
}
