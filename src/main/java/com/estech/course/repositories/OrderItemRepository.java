package com.estech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estech.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
