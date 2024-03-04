package br.com.example.pokedex.configuration.resilience;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerConfiguration {
	
//	private static final String SERVICE_NAME = "kanto-service";
	
//    @Bean
//    public RetryRegistry configureRetryRegistry() {
//        final RetryConfig retryConfig = RetryConfig.custom()
//                .maxAttempts(3)
//                //.waitDuration(Duration.ofMillis(5000)) //Either this OR
//                .intervalFunction(IntervalFunction.ofExponentialBackoff(IntervalFunction.DEFAULT_INITIAL_INTERVAL, 2)) // OR this
//                .retryOnException(new ConnectException())
//                .build();
//
//        return RetryRegistry.of(Map.of(SERVICE_NAME, retryConfig));
//    }

}
