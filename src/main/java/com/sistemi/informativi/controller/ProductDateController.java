package com.sistemi.informativi.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.informativi.bean.Product;

@CrossOrigin
@RestController
@RequestMapping("/rest/api/products/dates")
public class ProductDateController {
	
	
	/*
	 * Questo metodo rappresenta una operazione REST
	 * che si espone con verbo POST e con uri=/rest/api/products/dates
	 * e viene consumata dal Microservizio product-service tramite
	 * riga di codice:restTemplate.postForObject(apiUrl,savedProduct,Object.class);
	 */
	@PostMapping
	public @ResponseBody Object addDateToProduct(@RequestBody Product product) {
		
		Product productReceived = product;
		
		productReceived.setDate(new Date());
		
		return productReceived;
		
	}

}
