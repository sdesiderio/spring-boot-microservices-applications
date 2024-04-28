package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.component.Producer;
import com.example.model.CarOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private  Producer producer;


    @Override
    public String saveCarOrder(CarOrder carOrder) throws JsonProcessingException {
        return producer.sendMessage(carOrder);
    }

}
