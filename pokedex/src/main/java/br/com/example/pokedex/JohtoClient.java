package br.com.example.pokedex;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class JohtoClient implements RegionClient {

    WebClient client;

    @Override
    public JsonNode retrieve() {
        client = WebClient.create("http://localhost:8082/johto/details");

        return client.get().accept(MediaType.APPLICATION_JSON).retrieve()
                .onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals, response -> response.bodyToMono(String.class).map(Exception::new))
                .bodyToMono(JsonNode.class)
                .block();
    }
}
