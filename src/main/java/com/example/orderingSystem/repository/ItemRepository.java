package com.example.orderingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.orderingSystem.model.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    public List<ItemEntity> findItemEntitiesByOrder_Id(@Param("orderId") Long orderId);

}
