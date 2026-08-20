package com.example.springbk1.repository;

import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbk1.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
