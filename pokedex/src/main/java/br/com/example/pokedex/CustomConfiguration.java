package br.com.example.pokedex;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import br.com.example.pokedex.service.ConfigTest;

@Configuration
public class CustomConfiguration {

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ConfigTest getConfigTest() {
		return new ConfigTest("password-setted-in-configuration");
	}
}
