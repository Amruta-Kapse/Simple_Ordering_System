package com.example.orderingSystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.example.orderingSystem.model.entity.ItemEntity;
import com.example.orderingSystem.model.pojo.ItemDao;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

    ItemEntity itemDaoMapToItemEntity(ItemDao itemDao);
    @Mapping(target = "Id",source = "id")
    ItemDao itemEntityMapToItemDao(ItemEntity itemEntity);
	
	
}
