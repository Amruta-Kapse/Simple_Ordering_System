package com.example.orderingSystem.model.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Setter
@Getter
public class ItemDao {
	private Long Id;
	private String itemName;
	private String[] itemPieces;
	private double item_Price;
	private OrderDao order;

}
