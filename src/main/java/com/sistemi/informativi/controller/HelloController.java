package com.sistemi.informativi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.informativi.bean.MessageBean;

@RestController
@RequestMapping("/rest/api/hello")
public class HelloController {
	
	
	@GetMapping
	public MessageBean getHello() {
		
		return new MessageBean("hello");
		
		
	}

}
