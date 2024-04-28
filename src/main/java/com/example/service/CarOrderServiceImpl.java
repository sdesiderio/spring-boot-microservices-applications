package com.example.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CarOrderDTO;
import com.example.entity.CarOrder;
import com.example.repository.CarOrderRepository;

@Service
public class CarOrderServiceImpl implements CarOrderService{
	
    @Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CarOrderRepository carOrderRepository;

	@Override
	public void saveCarOrder(CarOrderDTO carOrderDTO) {
		
		CarOrder carOrder = modelMapper.map(carOrderDTO, CarOrder.class);
		carOrderRepository.save(carOrder);

		
	}

}
