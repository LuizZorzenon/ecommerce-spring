package com.zorzenon.crud.repository;

import com.zorzenon.crud.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
