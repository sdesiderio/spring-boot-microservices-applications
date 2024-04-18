package com.sistemi.informativi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sistemi.informativi.entity.Product;
import com.sistemi.informativi.repository.ProductRepository;

@RestController
@RequestMapping("/rest/api/products")
public class ProductController {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping
	public Object saveProduct(@RequestBody Product product) {
		
		// inserimento su database h2 di un prodotto che arriva dal consumer
		Product savedProduct = productRepository.save(product);
		
		/*
		 * url dell'operazione che si intende consumare rispetto dal microservizio
		 * che la espone
		 */
		
		String apiUrl = "http://microservice2:8301/rest/api/products/dates";
		
		
		
		/*
		 * Tramite API RestTemplate vogliamo consumare una operazione esposta da
		 * un altro microservizio
		 */
		Object response = restTemplate.postForObject(apiUrl,savedProduct,Object.class);
		
		return response;
		
		
	}

}
