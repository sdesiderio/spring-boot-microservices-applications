package com.sistemi.informativi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/api/users")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@GetMapping("/{name}")
	public Object getUserName(@PathVariable("name") String name) {
		
		
		/*
		 * Questo MICROSERVIZIO vuole effettuare una chiamata in GET
		 * ad un secondo MICROSERVIZIO passandogli il name ricevuto dello User 
		 * ricevuto dal primo microservizio
		 */
		
		/*
		 *  mapping del path dell'operazione esposta dal secondo microservizio
		 *  che verrà containerizzato all'interno di un Docker Container che
		 *  chiameremo welcome-service
		 */
		
		
		String apiUrl="http://welcome-service:9091/rest/api/welcome/" + name;
		
		
		/*
		 * Il metodo getForObject è un metodo predefinito dall'API
		 * RestTemplate che consente di fare una chiamata in GET
		 * ad un altro microservizio :
		 * 
		 * il metodo getForObject deve ricevere in input la url
		 * necessaria per il consumo del secondo microservizio, 
		 * Object.class in quanto il secondo microservizio potrebbe
		 * eleborare qualsiasi tipo di Oggetto Java ma astraendo con
		 * Object riusciamo tramite polimorfismo ad assorbire qualsiasi
		 * tipo di Oggetto venga costruito dal secondo microservizio,
		 * la o le informazioni che vogliamo trasferire nella chiamata
		 * GET al secondo microservizio
		 * 
		 * Il metodo getForObject ci consente di ottenere dal secondo
		 * microservizio invocato il body della risposta
		 * 
		 */
		
		
		
		return restTemplate.getForObject(apiUrl, Object.class, name);
		
		
		
		
		
	}
	
	
	

}
