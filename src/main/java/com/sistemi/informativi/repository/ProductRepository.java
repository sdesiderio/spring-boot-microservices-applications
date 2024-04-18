package com.sistemi.informativi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.informativi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
