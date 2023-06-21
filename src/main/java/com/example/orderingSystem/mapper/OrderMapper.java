package com.example.orderingSystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.example.orderingSystem.model.entity.OrderEntity;
import com.example.orderingSystem.model.pojo.OrderDao;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderEntity mapOrderToOrderEntity(OrderDao order);
    @Mapping(target = "Id",source = "id")
    OrderDao mapOrderEntityToOrderDao(OrderEntity orderEntity);




}
