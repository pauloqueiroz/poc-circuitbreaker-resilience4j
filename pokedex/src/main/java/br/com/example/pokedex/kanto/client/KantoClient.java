package br.com.example.pokedex.kanto.client;

import br.com.example.pokedex.RegionClient;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class KantoClient implements RegionClient {

	WebClient client;
	
	public JsonNode retrieve() {
		client = WebClient.create("http://localhost:8081/kanto/details");
		
		JsonNode responseObject = client.get().accept(MediaType.APPLICATION_JSON).retrieve()
        .onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals, response -> response.bodyToMono(String.class).map(Exception::new))
        .bodyToMono(JsonNode.class)
        .block();
		
		return responseObject;
	}

	public JsonNode retrieve(ProxyExchange<?> proxy) {
		return null;
	}

}
