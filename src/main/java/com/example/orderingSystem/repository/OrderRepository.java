package com.example.orderingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.orderingSystem.model.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    int countAllByCustomerId_Id(@Param("customerId") Long customerId);

    @Query(value = "SELECT  * FROM Order_Info where customer_id=customer_id", nativeQuery = true)
    List<OrderEntity> findAllByCustomerId_Id(@Param("customer_id") Long customerId);
}
