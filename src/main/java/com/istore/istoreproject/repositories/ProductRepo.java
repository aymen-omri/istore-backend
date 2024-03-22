package com.istore.istoreproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istore.istoreproject.models.Product;


public interface ProductRepo extends JpaRepository<Product , Long> {

    
}
