package com.estech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estech.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
