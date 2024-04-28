package com.example.service;

import com.example.model.CarOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CarService {
	
	
	public String saveCarOrder(CarOrder carOrder) throws JsonProcessingException;

}
