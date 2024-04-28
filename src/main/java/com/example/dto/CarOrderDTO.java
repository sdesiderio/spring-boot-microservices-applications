package com.example.dto;

public class CarOrderDTO {
	
	private String name;

	private String brand;

	private String model;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	protected CarOrderDTO() {

	}

	public CarOrderDTO(String name, String brand, String model) {

		this.name = name;
		this.brand = brand;
		this.model = model;
	}


}
