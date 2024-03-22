package br.com.example.pokedex.service;

import org.springframework.beans.factory.annotation.Value;

public class ConfigTest {

	
	private String foobar;

	public ConfigTest(@Value("${config.password}")String foobar) {
		super();
		this.foobar = foobar;
	}

	public String getFoobar() {
		return foobar;
	}

	public void setFoobar(String foobar) {
		this.foobar = foobar;
	}
	
	
}
