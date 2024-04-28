package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CarOrder;
import com.example.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/order")
public class CarController {
	
	@Autowired
    private CarService carService;

   
    @PostMapping
    public String saveCarOrder(@RequestBody CarOrder carOrder) throws JsonProcessingException {
        
        return carService.saveCarOrder(carOrder);
    }
}
