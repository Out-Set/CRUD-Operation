package com.example.springbootCRUD.Repository;

import com.example.springbootCRUD.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

    void deleteById(int id);

    void deleteByName(String name);
}
