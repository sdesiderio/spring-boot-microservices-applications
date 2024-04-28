package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.dto.CarOrderDTO;
import com.example.service.CarOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Consumer {

    @Autowired
    private  ObjectMapper objectMapper;
    
    @Autowired
    private  CarOrderService carOrderService;
    
    @KafkaHandler
    public void handleMessage(String message) {

    	System.out.println("message " + message);
    }

    @KafkaListener(topics ="t.car.order",groupId="default")
    public void consumeMessage(String message) throws JsonProcessingException {

    	System.out.println("message " + message);
    	
    	CarOrderDTO carOrderDto = objectMapper.readValue(message, CarOrderDTO.class);
    	carOrderService.saveCarOrder(carOrderDto);
    }
}
