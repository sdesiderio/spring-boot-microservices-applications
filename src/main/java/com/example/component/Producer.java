package com.example.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.model.CarOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Producer {
	
	private String orderTopic = "t.car.order";
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;


    public String sendMessage(CarOrder carOrder) throws JsonProcessingException {
    	
        String orderAsMessage = objectMapper.writeValueAsString(carOrder);
        kafkaTemplate.send(orderTopic, orderAsMessage);

        log.info("car order produced {}", orderAsMessage);

        return "message sent";
    }
}