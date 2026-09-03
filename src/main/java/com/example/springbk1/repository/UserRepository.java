package com.example.springbk1.repository;

import java.util.List;

import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbk1.entity.Order;
import com.example.springbk1.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // List<Order> findByUserId(Long userId);
     User findByEmailAndPassword(String email,String password);
}
