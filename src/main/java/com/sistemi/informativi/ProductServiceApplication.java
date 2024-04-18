package com.sistemi.informativi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	
	/*
	 * @Bean é una annotation tramite 
	 * la quale si può chiedere all'ApplicationContext
	 * di caricare un Spring Bean già conosciuto dal 
	 * Framework, allo start dell'applicazione
	 * 
	 * Quando Spring Boot vede un'annotation @Bean
	 * eseguie il metodo sottostante 
	 * 
	 * In questo caso Spring Boot esegue il contenuto
	 * del metodo getRestTemplate e pertanto crea
	 * una istanza di RestTemplate allocandola
	 * nell'HEAP
	 * 
	 *  Esistono tanti Bean di sistema che non
	 *  vengono precaricati di default dal Framework,
	 *  per cui in questi casi occorre chiedere
	 *  esplicitamente di farlo
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}

}
