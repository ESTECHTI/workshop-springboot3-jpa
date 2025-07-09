package com.estech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estech.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
