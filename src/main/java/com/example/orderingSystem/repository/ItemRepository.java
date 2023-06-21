package com.example.orderingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.orderingSystem.model.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>{



	//@Query(value="SELECT  * FROM  Items_info c INNER JOIN Order_Info o ON c.orderId=o.orderId WHERE c.orderId = :orderId",nativeQuery = true)
	public List<ItemEntity> findItemEntitiesByorder_Id(@Param("orderId") Long orderId);

}
