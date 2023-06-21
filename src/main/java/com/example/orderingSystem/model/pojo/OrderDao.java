package com.example.orderingSystem.model.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OrderDao {
    private Long Id;
    private CustomerDao customerId;
    protected List<ItemDao> items;
    private Double orderAmount;
}
