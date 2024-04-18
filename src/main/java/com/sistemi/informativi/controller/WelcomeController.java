package com.sistemi.informativi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.informativi.bean.MessageBean;

@RestController
@RequestMapping("/rest/api/welcome")
public class WelcomeController {
	
	
	/*
	 * metodo che viene eseguito dalla
	 * Dispatcher Servlet grazie alla chiamata
	 * in GET fatta dal primo microservizio
	 * 
	 * riceve in input il name inviato dal
	 * primo microservizio come PathVariable
	 * e costruisce in Oggetto MessageBean con
	 * il testo di benvenuto al name inviato
	 * dal primo microservizo
	 * 
	 * Tale Oggetto MessageBean sarà poi convertito
	 * dall'Object Mapper in JSON e restituito al
	 * primo microservizio
	 */
	@GetMapping("/{name}")
	public Object welcomeMessage(@PathVariable("name") String name) {
		
		
		return new MessageBean("welcome " + name);
		
		
	}

}
