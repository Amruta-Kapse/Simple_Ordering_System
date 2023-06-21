package com.example.orderingSystem.services;

import java.util.List;
import java.util.Optional;

import com.example.orderingSystem.model.pojo.ItemDao;
public interface ItemService {

	public Optional<ItemDao> addItem(ItemDao item);
	
	public Optional<ItemDao> updateItem(ItemDao item,Long itemId);
	
	public Optional<ItemDao> getItemById(Long itemId);
	
	public void removeItem(Long itemId);

	public Optional<List<ItemDao>> getAllItemsByOrderId(Long orderId);
	
}
