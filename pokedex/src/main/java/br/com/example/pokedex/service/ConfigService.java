package br.com.example.pokedex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
	
	ConfigTest config;
	
	private final ApplicationContext applicationContext;
	
	@Autowired
	public ConfigService(ConfigTest config, ApplicationContext applicationContext) {
		super();
		this.config = config;
		this.applicationContext = applicationContext;
	}

	public ResponseEntity<?> getConfig(){
		System.out.println("ConfigService Password before reinitializing: "+config.getFoobar());
		reinitializeBean(); 
		System.out.println("ConfigService Password after reinitializing: "+config.getFoobar());

		return ResponseEntity.ok("password: "+config.getFoobar());
	}

	private void reinitializeBean() {
		DefaultSingletonBeanRegistry registry = (DefaultSingletonBeanRegistry) applicationContext.getAutowireCapableBeanFactory();
	    registry.destroySingleton("configTest");
	    var singletonObject = new ConfigTest("password-reinitialized");
		registry.registerSingleton("configTest", singletonObject);
		System.out.println("application Context Password reinitialized: "+singletonObject.getFoobar());
	}

}
