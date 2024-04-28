package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CarOrder;

public interface CarOrderRepository extends JpaRepository<CarOrder,Integer>{

}
