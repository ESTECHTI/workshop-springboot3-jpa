package com.estech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estech.course.entities.Category;
import com.estech.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
