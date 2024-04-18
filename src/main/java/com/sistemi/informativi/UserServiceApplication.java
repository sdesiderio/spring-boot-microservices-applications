package com.sistemi.informativi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	/*
	 * Richiesta a Spring Boot
	 * di istanziare, allo start 
	 * dell'Applicazione, l'Oggetto
	 * RestTemplate che useremo
	 * nello UserController per
	 * consumare una operazione
	 * esposta dal secondo microservizio
	 * che verrà containerizzato all'interno
	 * di un Docker Containet di nome
	 * welcome-service
	 */
	@Bean
	RestTemplate restTemplate() {
		
		return new RestTemplate();
		
	}

}
