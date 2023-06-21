package com.example.orderingSystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.example.orderingSystem.model.entity.CustomerEntity;
import com.example.orderingSystem.model.pojo.CustomerDao;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
	CustomerEntity mapToCustomerEntity(CustomerDao customerDao);
	@Mapping(target = "Id",source = "id")
	CustomerDao mapToCustomerDao(CustomerEntity customerEntity);
}
