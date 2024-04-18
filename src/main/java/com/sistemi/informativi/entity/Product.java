package com.sistemi.informativi.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = -8690501177951233360L;
	
	@Id
	private String code;
	
	private String name;
	
	private String origin;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
	protected Product(){
		
		
	}

	public Product(String code, String name, String origin) {
		
		this.code = code;
		this.name = name;
		this.origin = origin;
	}
	
	

}
